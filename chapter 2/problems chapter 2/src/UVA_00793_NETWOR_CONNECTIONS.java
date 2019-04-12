import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class UVA_00793_NETWOR_CONNECTIONS {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		int cas= Integer.parseInt(br.readLine());
		br.readLine();

		for(int ca= 0;ca<cas;ca++) {
			int numComputers= Integer.parseInt(br.readLine());
			int[] p = new int[numComputers+1];
			int[] r= new int[numComputers+1];
			for(int i=0;i<p.length;i++) {
				p[i]=i;
			}
			String l=	br.readLine();
			int s=0;
			int ns=0;
			while(l != null&&!l.equals("")) {
				String[] r1= l.split(" ");
				if(r1[0].contentEquals("c")) {
					unionSet(Integer.parseInt(r1[1]), Integer.parseInt(r1[2]), p, r);
				}else {
					boolean answ= isSameSet(Integer.parseInt(r1[1]), Integer.parseInt(r1[2]), p);
					if(answ) {
						s++;
					}else {
						ns++;
					}
				}
				l= br.readLine();
			}
			bw.write(s+","+ns+"\n");
			if(ca+1!= cas)
				bw.write("\n");
			
		}
		bw.close();
	}
	
	public static int findSet(int i, int[] p) {
		return (p[i]==i)?i: (p[i]=findSet(p[i], p));
	}
	public static boolean isSameSet(int i, int j, int[] p) {
		return findSet(i, p)==findSet(j, p);
	}
	public static void unionSet(int i ,int j, int[] p, int[] r) {
		int x=findSet(i, p), y= findSet(j, p);
		if(r[x]>r[y]) {
			p[y]=x;
		}else {
			p[x]=y;
			if(r[x]==r[y]) r[y]++;
		}
	}
}
