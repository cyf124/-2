package com.tool;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;
/**
 * 
 * @author Administrator
 *
 */
public class SegmentTool {
	
	private static final int MAXSIZE = 30;
	
	/**
	 * 根据字符流分词
	 * @param text
	 * @return
	 * @throws IOException
	 */
	public static Map getTextDef(Reader text) throws IOException {
		Map<String, Integer> wordsFren=new HashMap<String, Integer>();
		try{
		      IKSegmenter ikSegmenter = new IKSegmenter(text, true);
		      Lexeme lexeme;
		      while ((lexeme = ikSegmenter.next()) != null) {
		          if(lexeme.getLexemeText().length()>1){
		              if(wordsFren.containsKey(lexeme.getLexemeText())){
		                  wordsFren.put(lexeme.getLexemeText(),wordsFren.get(lexeme.getLexemeText())+1);
		              }else {
		                  wordsFren.put(lexeme.getLexemeText(),1);
		              }
		           }
		      }
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		// 保留前MAXSIZE个
		Entry<String, Integer> maxOne = null;
		List<Integer> array = new ArrayList<Integer>();
		Map<String, Integer> result = new HashMap<String, Integer>();
		if (wordsFren.size() > MAXSIZE) {
			for (int i = 0; i < MAXSIZE; ++i) {
				for (Entry<String, Integer> entry : wordsFren.entrySet()) {
					if (maxOne == null || maxOne.getValue() < entry.getValue()){
						maxOne = entry;
					}
				}
				result.put(maxOne.getKey(), maxOne.getValue());				
				wordsFren.remove(maxOne.getKey());
				maxOne = null; 
			}
		} else {
			result = wordsFren;
		}
		
        return result;
    }
	
	/**
	 * 将map转化为JSON
	 * @param map
	 * @return
	 */
	public static JSONArray mapToJSON(Map<String,Integer> map){
		
		int max = 0;
		for (Entry<String, Integer> entry : map.entrySet()) {
			if(max < entry.getValue()){
				max = entry.getValue();
			}
		}
		
		JSONArray jobj = new JSONArray();
		JSONObject i = new JSONObject();
		i.put("word","");
		i.put("num", "");
		i.put("radius",0);
		i.put("max", max);
		jobj.add(i);
		
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry entry = (Map.Entry) it.next();  
			JSONObject j = new JSONObject();
			float numm = Float.parseFloat((entry.getValue().toString()));
			j.put("word",entry.getKey().toString());
			j.put("num", entry.getValue().toString());
			j.put("radius",numm/max*30+8);//这里有设置半径，与max有关
			jobj.add(j);
		}
		
		return jobj;
	}
}
