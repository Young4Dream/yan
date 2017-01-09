/**
 * 
 */
package com.tstar.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.oro.text.perl.Perl5Util;
import org.apache.oro.text.regex.MatchResult;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.PatternMatcherInput;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;

/**
 * @author zhumengfeng
 *
 */
public class RegExp {

	public final static String PATTERN_EMAIL = "([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)";
	public final static String PATTERN_VAIRALBE = "/#\\{[_a-z0-9A-Z]+\\}/";
	
	private static PatternCompiler compiler = new Perl5Compiler();
	private static PatternMatcher matcher = new Perl5Matcher();
	private static Map<String, Pattern> patterns = new HashMap<String, Pattern>();
	
	public static String getValue(String regexp, String source, int index) {
		try {
			Pattern pattern = patterns.get(regexp);
			if (pattern == null) {
				pattern = compiler.compile(regexp);
				patterns.put(regexp, pattern);
			}
			if (matcher.contains(source, pattern)) {
				MatchResult result = matcher.getMatch();
				if (result == null) return null;
				int len = result.groups();
				if (len > 0) {
					if (index > 0 && index <= len) {
						return result.group(index);
					} else {
						return result.group(len - 1);
					}
				} else {
					return null;
				}
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String[] getValues(String regexp, String source) {
		try {
			Pattern pattern = patterns.get(regexp);
			if (pattern == null) {
				pattern = compiler.compile(regexp);
				patterns.put(regexp, pattern);
			}
			if (matcher.contains(source, pattern)) {
				MatchResult result = matcher.getMatch();
				if (result == null) return null;
				int count = result.groups();
				//System.out.println("count=" + count);
				if (count > 0) {
					String[] groups = new String[count - 1];
					for (int i = 0; i < count - 1; i++) {
						groups[i] = result.group(i + 1);
					}
					return groups;
				} else {
					return null;
				}
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
	
	public static boolean matches(String regexp, String source) {
		if (regexp == null || regexp.equals("") || regexp.equals("*")) {
			return true;
		}
		try {
			Pattern pattern = patterns.get(regexp);
			if (pattern == null) {
				pattern = compiler.compile(regexp);
				patterns.put(regexp, pattern);
			}
			return matcher.matches(source, pattern);
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 查找变量名，变量名格式为#{name}
	 * @param source
	 * @return
	 * @throws Exception
	 */
	public static String[] findVariables(String source) {
		Perl5Util p = new Perl5Util();
		PatternMatcherInput mi = new PatternMatcherInput(source);
		List<String> rs = new ArrayList<String>();
		while (p.match(PATTERN_VAIRALBE, mi)) {
			MatchResult ms = p.getMatch();
			String res = ms.toString();
			rs.add(res.substring(2, res.length() - 1));
		}
		return (String[])(rs.toArray(new String[rs.size()]));
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		/*
		String reg = "^APP_KEY-(.*)\\s+userID-(.*)\\s+.*";
		String val = "APP_KEY-K_B8HjwaA_yaAQvDB1pBw52Nbpka userID-sip:+862886544076@sc.chinamobile.com ";
		System.out.println("appkey: " + RegExp.getValue(reg, val, 1));
		System.out.println("userID: " + RegExp.getValue(reg, val, 2));
		reg = "^(tel:)?\\+?(86)?(\\d+)";
		val = "tel:937812210099";
		System.out.println("number: " + RegExp.getValue(reg, val, 0));
		
		reg = "^(?!(None)).*$";
		//reg = "^(?!None)";
		val = "ab";
		System.out.println(val + " matches " + reg + ": " + val.matches(reg));
		
		String url = System.getProperty("user.dir") + System.getProperty("file.separator");
		System.out.println("url=" + url);
		
		reg = "RETCODE = (\\d+) ";
		val = "++++++++++++++++++++++++++++++++++++++++++++++++++++" + "\r\n";
		//val = val.replaceAll("[\\t\\r\\n]", "");
		String[] groups = getValues(reg, val);
		System.out.println("groups.size=" + groups.length);
		if (groups != null && groups.length > 0) {
			for (String g : groups) {
				System.out.println(g);
			}
		}
		
		reg = "#\\{([_a-z0-9A-Z]+)\\}";
		val = "LGI:OP=#{o_p},PWD=#{pwd};";
		
		groups = getValues(reg, val); 
		if (groups != null){
			for (String g:groups) {
				System.out.println(g);
			}
		}
		*/
		String val = "LGI:OP=#{op},PWD=#{pwd};";
		String[] gs = findVariables(val);
		for (String g : gs) {
			System.out.println(g);
		}
		System.out.println(val.replace("#{op}", "tfjcs").replace("#{pwd}", "123"));
	}

}
