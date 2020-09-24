import domains.Article;
import service.ReaderService;
import service.WriterService;

import java.util.ArrayList;
import java.util.Date;

public class MyApp {

    public static void main(String[] args) {
        System.out.println("hello");

        ReaderService readerService = new ReaderService();
        WriterService writerService = new WriterService();

        writerService.addArticleByWriter("salam"+new Date(System.currentTimeMillis()));

        readerService.commentOnArticle(3L,"very good");

        System.out.println(readerService.loadAllArticle());





    }
}
