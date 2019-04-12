import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class UVA_1197_The_Suspects {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		String[] cas= br.readLine().split(" ");
		while(Integer.parseInt(cas[0])!=0 || Integer.parseInt(cas[1])!=0) {
			int n= Integer.parseInt(cas[0]);
			int m=Integer.parseInt(cas[1]);
			int[] p =new int[n];
			int[] r= new int[n];
			for(int i=0;i<p.length;i++) {
				p[i]=i;
			}
			for(int i=0;i<m;i++) {
				String[] g= br.readLine().split(" ");
				for(int j=1;j<g.length-1;j++) {
					if(!g[j].contentEquals("")) {
						unionSet(Integer.parseInt(g[j]), Integer.parseInt(g[j+1]), p, r);
					}
				}
			}
			cas=br.readLine().split(" ");
			int cont= 1;
			for(int i=1;i<n;i++) {
				if(isSameSet(0, i, p)) {
					cont++;
				}
			}
			bw.write(cont+"\n");
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
