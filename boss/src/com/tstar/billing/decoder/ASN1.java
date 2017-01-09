package com.tstar.billing.decoder;

import java.util.ArrayList;
import java.util.List;

import com.tstar.ocs.model.Cdr;
import com.tstar.util.BeanHelper;
import com.tstar.util.ByteHelper;
import com.tstar.util.FileHelper;
import com.tstar.util.Log;
import com.tstar.util.RegExp;

public class ASN1 implements IDecoder {

	public static final int FILE_HEAD_LENGTH = 50;
	public static final int CDR_HEAD_LENGTH = 4;
	public static final int CDR_HEAD_LEN_VALUE = 2;
	
	private DecoderConfig config;
	
	public void setStartPos(int pos) {}
	
	/**
	 * Decode 
	 * @param content - file content
	 * @return - List of cdr
	 */
	public List<Cdr> decode(byte[] content, DecoderConfig config)
			throws Exception {
		this.config = config;
		List<Cdr> rows = new ArrayList<Cdr>();
		// 总长度
		int len = content.length;
		// 初始位置
		int pos = FILE_HEAD_LENGTH;
		while (pos < len) {
			int rowLen = getRowLength(content, pos);
			Cdr row = getRow(content, pos);
			//if (row.business == null || "".equals(row.business)) {
			//	row.business = config.category;
			//}
			rows.add(row);
			pos += rowLen + CDR_HEAD_LENGTH;
		}
		return rows;
	}

	public List<Cdr> decode(String filePath, DecoderConfig config)
			throws Exception {
		byte[] content = FileHelper.copyFile(filePath);
		if (content == null) return null;
		return decode(content, config);
	}

	/**
	 * Get the cdr row length
	 * @param content - file content
	 * @return - row length
	 */
	private static int getRowLength(byte[] content, int pos) {
		return ByteHelper.Bytes2Int(content, pos, ASN1.CDR_HEAD_LEN_VALUE);
	}
	
	/**
	 * Get cdr row
	 * @param content
	 * @param start
	 * @return
	 * @throws Exception
	 */
	private Cdr getRow(byte[] content, int start) throws Exception {
		Cdr cdr = new Cdr();
		int pos = start + CDR_HEAD_LENGTH;
		// Get root tag
		TagBean root = getTag(content, pos);
		// Get valid field count
		int fieldCount = config.fieldCount;
		// push root node into stack 
		List<DecodeStackItem> stack = new ArrayList<DecodeStackItem>();
		stack.add(new DecodeStackItem(root, config.nodes));
		// re-position
		pos = root.pos;
		int fieldIndex = 0;
		while (pos < root.pos + root.len) {
			// Get the parent information, at the top of stack
			DecodeStackItem parent = (DecodeStackItem)stack.get(stack.size()-1);
			// Get next tag
			TagBean tag = getTag(content, pos);
			// Make sure the tag defined
			IDecoderConfigNode con = parent.nodes.get("" + tag.id);
			if (con == null) {
				// Undefined tag, ignore it
				// Move the point to the next tag header
				pos = tag.pos + tag.len;
				// If the tag is last, pop it from stack
				if (pos == parent.tag.pos + parent.tag.len) {
					stack.remove(stack.size() - 1);
				}
				continue;
			} else if (tag.atom) {
				// The tag is an atom
				DecoderConfigLeaf field = (DecoderConfigLeaf)con;
				tag.value = ByteHelper.Bytes2Object(content, tag.pos, tag.len, field.dataType);
				if (tag.value != null) {
					if (field.ifval == null || "".equals(field.ifval) || field.ifexp == null || "".equals(field.ifexp)) {
						Object value;
						if (field.pattern == null) {
							value = tag.value;
						} else {
							value = RegExp.getValue(field.pattern, (String)tag.value, field.patternIndex);
						}
						BeanHelper.setProperty(cdr, field.field, value);
					} else {
						if (field.ifexp.equals(tag.value.toString())) {
							if ("business".equals(field.field)) {
								cdr.setServiceAbbr(field.ifval);
							}
						}
					}
				}
				Log.getLogger().debug("leaf.tag.id=" + tag.id + ", field=" + field.field + ", value=" + tag.value);
				fieldIndex++;
				if (fieldIndex >= fieldCount) {
					// This is the last field, ignore the remaining tag
					break;
				}
				// Move the point to the next tag header
				pos = tag.pos + tag.len;
				// If the tag is last, pop it from stack
				if (pos == parent.tag.pos + parent.tag.len) {
					stack.remove(stack.size() - 1);
				}
			} else {
				Log.getLogger().debug("trunk.tag.id=" + tag.id + ", tag.pos=" + tag.pos);
				// Move the point to the first sub tag header
				pos = tag.pos;
				// The tag is a TLV, push it into stack
				stack.add(new DecodeStackItem(tag, ((DecoderConfigTrunk)con).nodes));
			}
		}
		//System.out.println("cdr.caller=" + cdr.getCaller() + ", cdr.callee=" + cdr.getCallee());
		// Set Service_category_Abbr
		//BeanHelper.setProperty(cdr, "serviceAbbr", config.category);
		cdr.setServiceAbbr(config.category);
		return cdr;
	}
	
	private TagBean getTag(byte[] content, int start) {
		TagBean tag = new TagBean();
		int pos = start;
		// Get Tag Id, two types of tag
		// long tag - bit 1 - 5 all one, the leading bytes bit 8 all one, and the last byte bit 8 is zero, 
		// short tag - tag value is less than 31
		// bit 6: 0 - atom, 1 - construct
		byte b = content[pos];
		tag.atom = ((b & 0x20) != 0x20);
		if ((b & 0x1f) == 0x1f) {
			int newPos = pos;
			// Search the first byte whose bit 8 is zero
			while((content[newPos] & 0x80) == 0x80) {
				newPos++;
			}
			tag.id = ByteHelper.Bytes2Int(content, pos, newPos - pos + 1);
			pos = newPos + 1;
		} else {
			tag.id = ByteHelper.Bytes2Int(content, pos, 1);
			pos++;
		}
		// Get Tag Length
		// short len - first byte is less than 128
		// long len - first byte greater than 127, bit 8 is one, bit 1 - 7 means byte length
		b = content[pos];
		if ((b & 0x80) == 0) {
			tag.len = (b & 0x7f);
			pos++;
		} else {
			int size = (b & 0x7f);
			tag.len = ByteHelper.Bytes2Int(content, ++pos, size);
			pos += size;
		}
		tag.pos = pos;
		return tag;
	}
}
