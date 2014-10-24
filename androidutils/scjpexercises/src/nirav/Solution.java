package nirav;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

	 
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int latestblock=1;
		BufferedReader br = new BufferedReader(new FileReader("MIR.txt"));
		String line;
		boolean nextLineBlock = false,curlinenextaftergoto=false;
		List<String> prog = new ArrayList<String>();
		List<BlockOfCode> blocklist = new ArrayList<BlockOfCode>();
		blocklist.add(new BlockOfCode(1));
		Map<String,Integer> labelmap = new HashMap<String, Integer>();
		int linecnt=1;
		while((line = br.readLine())!=null){
			//System.out.println(line);
			prog.add(line);
			
			if(nextLineBlock){
				if(line.contains(":")){
					curlinenextaftergoto = true;
				}
				latestblock++;
				BlockOfCode block = new BlockOfCode(linecnt-1);
				blocklist.add(block);
				nextLineBlock = false;
			}
				
			
			if(line.contains("goto")){
				System.out.println("# "+(linecnt+1)+" statement after branch statement");
				nextLineBlock = true;
				
			} 
			if(line.contains(":")) { 
				if(curlinenextaftergoto){
					curlinenextaftergoto = false;
					
					StringTokenizer st = new StringTokenizer(line, ":");
					labelmap.put(st.nextToken().trim(), linecnt-1);
					continue;
				}
				
				StringTokenizer st = new StringTokenizer(line, ":");
				labelmap.put(st.nextToken().trim(), linecnt-1);
				System.out.println();
				latestblock++;
				System.out.println("# "+linecnt+" statement with label");
				BlockOfCode block = new BlockOfCode(linecnt-1);
				blocklist.add(block);
				blocklist.get(blocklist.size()-2).nextHead1=blocklist.get(blocklist.size()-1).head;
			}
			
			System.out.println("block no "+latestblock+" : "+line);
			System.out.println(blocklist.size());
			linecnt++;			
		}

		for(String st : labelmap.keySet() ){
			System.out.println(st+""+labelmap.get(st));
		}
		
		
		for(BlockOfCode bl : blocklist){
		//	bl.head-=1;
			System.out.println(bl.head);
		}
		
		int cnt=0;
		
		for(int j = 0; j< prog.size();j++ ){
			if(j<blocklist.get(cnt+1).head){
				blocklist.get(cnt).appendline(prog.get(j));
				if(prog.get(j).contains("goto")){
					StringTokenizer st2 = new StringTokenizer(prog.get(j), "goto");
					
					if(prog.get(j).contains("If")){
						blocklist.get(cnt).setNextHead1(blocklist.get(cnt+1).head);
					}
					
					String tok="";
					while(st2.hasMoreTokens()){
						tok = st2.nextToken();
					}
					tok  = tok.trim();
					System.out.println("Last Token -"+tok+"kkkkk");
					blocklist.get(cnt).nextHead2=labelmap.get(tok);
					System.out.println("Going to :"+labelmap.get(tok)+"kkkkk");
				}
				if(prog.get(j).contains("Return")){
					blocklist.get(cnt).nextHead1=0;
					blocklist.get(cnt).nextHead2=0;
				}
				
				
				
			} else {
				cnt++;
				blocklist.get(cnt).appendline(prog.get(j));
				if(prog.get(j).contains("goto")){
					StringTokenizer st2 = new StringTokenizer(prog.get(j), "goto");
					
					String tok="";
					while(st2.hasMoreTokens()){
						tok = st2.nextToken();
					}
					tok  = tok.trim();
					
					if(prog.get(j).contains("If")){
						blocklist.get(cnt).setNextHead1(blocklist.get(cnt+1).head);
					}
					
					System.out.println("Last Token -"+tok+"kkkkk");
					blocklist.get(cnt).nextHead2=labelmap.get(tok);
					System.out.println("Going to :"+labelmap.get(tok)+"kkkkk");
				}
				if(prog.get(j).contains("Return")){
					blocklist.get(cnt).nextHead1=0;
					blocklist.get(cnt).nextHead2=0;
				}
				

			}
		}
		
		
		for(BlockOfCode bl : blocklist){
			System.out.println(bl);
		}
		
		
		
		
		
		
	}

}
