public class CityWithSmallestNumberOfThresholdDistance {
    int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        // code here
        int[][] distance = new int[n][n];
        for(int i=0; i< n; i++){
            for(int j =0; j< n; j++){
                if(i == j)distance[i][j] =0;
                else distance[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int[] arr: edges){
            int u = arr[0];
            int v = arr[1];
            int wt = arr[2];
            distance[u][v] = wt;
            distance[v][u] = wt;
        }

        for(int via =0; via<n; via++){
            for(int i=0; i<n; i++){
                for(int j =0; j<n; j++){
                    if(distance[i][via]== Integer.MAX_VALUE || distance[via][j] == Integer.MAX_VALUE)continue;
                    distance[i][j] = Math.min(distance[i][j], distance[i][via] + distance[via][j]);
                }
            }
        }

        int cityCount = n;
        int CityNo = -1;
        for(int city =0; city< n; city++){
            int count = 0;
            for(int adjCity =0; adjCity< n; adjCity++){
                if(distance[city][adjCity] <= distanceThreshold) count++;
            }
            if(count<= cityCount){
                cityCount = count;
                CityNo = city;
            }
        }
        return CityNo;

    }
}
