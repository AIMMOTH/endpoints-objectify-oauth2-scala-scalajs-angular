package io.cenet.endpoints.result;

import java.util.ArrayList;
import java.util.List;

public class ListIdResult {

	public List<Long> ids = new ArrayList<Long>();
	
	ListIdResult() {}
	
	public ListIdResult(List<Long> ids) {
		this.ids = ids;
	}
}
