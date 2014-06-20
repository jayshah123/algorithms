import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ArrayList<WindowState> arr = new ArrayList<WindowState>();
		WindowState ws = null;
		BufferedReader br = new BufferedReader(new FileReader(
				"C:\\Users\\Jay\\normaldialog"));
		String line = null;
		br.readLine();
		br.readLine();
		// parsing start

		while ((line = br.readLine()) != null) {
			line = line.trim();
			line = line.replace("{", "");
			line = line.replace("}", "");
			// line 1
			if (line.contains("Window #")) {
				String sarr[] = line.split(" ");
				ws = new WindowState();
				ws.title = sarr[3];
				ws.stackPos = arr.size();
				arr.add(ws);
			}

			// line 2
			if (line.contains("mSession=Session")) {
				String sarr[] = line.split(" ");
				ws.mSessionuid = Integer.valueOf(sarr[2]);
			}

			// line 3
			if (line.contains("mAttrs=WM.LayoutParams")) {
				ws.wmlp = new Wmlayoutparams();
				line = line.replace("wrap", "-2");
				line = line.replace("fill", "-1");
				StringTokenizer stz = new StringTokenizer(line, " ()x=,#");
				while (stz.hasMoreTokens()) {
					String str = stz.nextToken();
					if (Character.isLetter(str.charAt(0))) {
						if (str.equals("WM.LayoutParams")) {
							ws.wmlp.x = Integer.valueOf(stz.nextToken());
							ws.wmlp.y = Integer.valueOf(stz.nextToken());
							ws.wmlp.width = Integer.valueOf(stz.nextToken());
							ws.wmlp.height = Integer.valueOf(stz.nextToken());
							// System.out.println("\t"+stz.nextToken()+"\t"+stz.nextToken()+"\t"+stz.nextToken()+"\t"+stz.nextToken());
						}
						if (str.equals("sim")) {
							ws.wmlp.sim = Integer.valueOf(stz.nextToken());
						}
						if (str.equals("ty")) {
							ws.wmlp.type = Integer.valueOf(stz.nextToken());
						}
						if (str.equals("fl")) {
							ws.wmlp.flag = Integer.valueOf(stz.nextToken());
						}
						if (str.equals("pfl")) {
							ws.wmlp.pfl = Integer.valueOf(stz.nextToken());
						}
						if (str.equals("fmt")) {
							ws.wmlp.format = Integer.valueOf(stz.nextToken());
						}
						if (str.equals("wanim")) {
							ws.wmlp.wanim = Integer.valueOf(stz.nextToken());
						}
						if (str.equals("gr")) {
							ws.wmlp.gravity = Integer.valueOf(stz.nextToken());
						}
					}

				}
			} // line 3 ends

			// line 4
			if (line.contains("Requested")) {
				StringTokenizer stz = new StringTokenizer(line, " =");
				stz.nextToken();
				while (stz.hasMoreTokens()) {
					String str = stz.nextToken();
					if (Character.isLetter(str.charAt(0))) {
						if (str.equals("w")) {
							ws.requestedWidth = Integer.parseInt(stz.nextToken());
						}
						if (str.equals("h")) {
							ws.requestedHeight = Integer.parseInt(stz.nextToken());
						}
						if (str.equals("mLayoutSeq")) {
							ws.mLayoutSeq = Integer.parseInt(stz.nextToken());
						}
					}
				}

			} //line 4 ends
			
			

			// line 5
			if(line.contains("mBaseLayer")){
				StringTokenizer stz = new StringTokenizer(line, " =");
				while (stz.hasMoreTokens()) {
					String str = stz.nextToken();
					if (Character.isLetter(str.charAt(0))) {
						if (str.equals("mBaseLayer")) {
							ws.mBaseLayer = Integer.parseInt(stz.nextToken());
						}
						if (str.equals("mSubLayer")) {
							ws.mSubLayer = Integer.parseInt(stz.nextToken());
						}
						if (str.equals("mAnimLayer")) {
							ws.mAnimLayer = Integer.parseInt(stz.nextToken(" =+"));
						}
						if (str.equals("mLastLayer")) {
							ws.mLastLayer = Integer.parseInt(stz.nextToken());
						}
					}
				}
			}//line 5 ends
			

			// line 6
			if(line.contains("mToken=")){
				
				
				
			}//line 6 ends
			
			
			//line 7
			if(line.contains("mRootToken=")){
				
				
				
			}// line 7 ends
			
			//line 8
            if(line.contains("mAppToken=")){
				
				
				
			}
			
			//line 9

		}

		// parsing end

		printallwindowstates(arr);

	}

	public static void printallwindowstates(ArrayList<WindowState> arr) {
		for (WindowState wss : arr) {
			System.out.println(" printing = " + wss);
		}
	}

}
