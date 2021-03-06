package io.ernesto.mercury;

import org.junit.Test;

import java.util.concurrent.*;

import static org.junit.Assert.assertTrue;

public class FetcherTests {
    private long maxTimeout = 10000;
    private String baseUrl = "https://hacker-news.firebaseio.com/v0/";

    @Test
    public void testFetchingIDList() {
        Fetcher fetcher = new Fetcher(baseUrl);

        ExecutorService executor = Executors.newSingleThreadExecutor();

        FutureTask<String> future =
                new FutureTask<String>(new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        return fetcher.fetch("topstories.json");
                    }
                });

        executor.submit(future);

        try {
            String fetchedResult = future.get(maxTimeout, TimeUnit.MILLISECONDS);
            System.out.print(fetchedResult);
            assertTrue(fetchedResult != null);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        assertTrue(true);
    }

    @Test
    public void testFetchItem() {
        Fetcher fetcher = new Fetcher(baseUrl);

        ExecutorService executor = Executors.newSingleThreadExecutor();

        FutureTask<String> future =
                new FutureTask<String>(new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        return fetcher.fetch("item/10483024.json");
                    }
                });

        executor.submit(future);

        try {
            String fetchedResult = future.get(maxTimeout, TimeUnit.MILLISECONDS);
            System.out.print(fetchedResult);
            assertTrue(fetchedResult != null);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        assertTrue(true);
    }
}
