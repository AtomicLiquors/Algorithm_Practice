import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class HSAT_11001 {

    private static class Decimal implements Comparable<Decimal>{

        Integer integer;
        Integer fractional;

        public Decimal(int integer, int fractional) {
            this.integer = integer;
            this.fractional = fractional;
        }

        public Decimal(int integer) {
            this.integer = integer;
        }

        @Override
        public int compareTo(Decimal d){
            if(this.integer != d.integer)
                return this.integer - d.integer;
            if(this.fractional == null || d.fractional == null)
                return (this.fractional == null ? -1 : 0) + (d.fractional == null ? 1 : 0);
            return this.fractional - d.fractional;
        }

        @Override
        public String toString(){
            return this.integer + "." + this.fractional;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Decimal> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        while(N-- > 0){
            String[] tokens = br.readLine().split("\\.");

            Decimal curr =
                    tokens.length > 1 ?
                            new Decimal(
                                    Integer.parseInt(tokens[0]),
                                    Integer.parseInt(tokens[1])
                            ) :
                            new Decimal(
                                    Integer.parseInt(tokens[0])
                            );
            pq.offer(curr);

        }


        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            Decimal dec = pq.poll();
            sb.append(dec.integer);
            if(dec.fractional != null)
                sb.append('.').append(dec.fractional);
            sb.append('\n');
        }


        System.out.print(sb);
    }
}
