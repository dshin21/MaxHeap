import java.util.PriorityQueue;

public class Main {
    public static void main( String[] args ) {
        int[] a = { 4, 5, 1, 6, 2, 7, 3, 8 };
        smallestKNumbers( a, 4 );
    }

    private static void smallestKNumbers( int a[], int k ) {
        PriorityQueue<Integer> pq = new PriorityQueue<>( k, ( Integer one, Integer two ) -> two - one );

        for ( int i = 0; i < k; ++i ) pq.offer( a[ i ] );

        for ( int i = k; i < a.length; ++i )
            if ( a[ i ] < pq.peek() ) {
                pq.poll();
                pq.offer( a[ i ] );
            }
        System.out.print("Smallest k numbers: ");
        for ( int i = 0; i < k; ++i ) System.out.print( pq.poll() + "\t" );
    }
}
