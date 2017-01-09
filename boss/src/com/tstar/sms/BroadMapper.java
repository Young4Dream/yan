package com.tstar.sms;

import java.util.Map;

public interface BroadMapper {
	int select(Map<String, Object> map);
	void execute(Map<String, Object> map);
}
