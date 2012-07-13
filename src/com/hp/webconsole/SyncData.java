/**
 * 
 */
package com.hp.webconsole;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liupow
 *
 */
public final class SyncData {
	
	private static Map<String, SyncData> datas = Collections.synchronizedMap(new HashMap<String, SyncData>());
	
	private List<Object> data;
	
	private SyncData(){
		data = new ArrayList<Object>();
	}
	
	public static SyncData getInstance(String jobId){
		if(datas.containsKey(jobId)){
			return datas.get(jobId);
		}
		SyncData sd = new SyncData();
		datas.put(jobId, sd);
		return sd;
	}

	/**
	 * @return the data
	 */
	public List<Object> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 * @return SyncData use for chained operation
	 */
	public SyncData putData(Object data) {
		this.data.add(data);
		return this;
	}
	
	public String getDate(String start){
		int i = 0;
		try {
			i = Integer.parseInt(start);
		} catch (Throwable e) {
		}
		return getDate(i);
	}
	public String getDate(int start){
		int size = data.size();
		StringBuffer sb = new StringBuffer(size + ":");
		for (int i = start; i < size; i ++){
			sb.append("\n").append(data.get(i));
		}
		return sb.toString();
	}

}
