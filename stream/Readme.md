int[][] answer = Arrays.stream(data).filter(o1 -> o1[extIdx] < val_ext)
            .sorted((o1 ,o2) -> o1[sortIdx]-o2[sortIdx]).toArray(int[][]::new);\
이거 해석해서 적어달라.
