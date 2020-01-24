/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.javaio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *
 * @author tss
 */
public class App1 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/home/tss/echo.txt");
        System.out.println(path.getFileName());

        System.out.println(Files.isReadable(path));

        Files.copy(Paths.get("/home/tss/echo.txt"), Paths.get("/home/tss/echo(copia).txt"),
                StandardCopyOption.REPLACE_EXISTING);
        Files.lines(Paths.get("/home/tss/echo.txt")).forEach(System.out::println);

        Path createTempFile = Files.createTempFile(Paths.get("/tmp"), "aa_", "zz");

        System.out.println(Files.getOwner(path));

        Files.newDirectoryStream(Paths.get("/tmp")).forEach(System.out::println);

        Files.walkFileTree(Paths.get("/tmp"), new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path arg0, BasicFileAttributes arg1) throws IOException {
                if (Files.isHidden(arg0)) {
                    return FileVisitResult.SKIP_SUBTREE;
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path arg0, BasicFileAttributes arg1) throws IOException {
                System.out.println("visitFile() -> " + arg0.toString());
                if (!Files.isDirectory(arg0) && Files.isReadable(arg0) && !Files.isHidden(arg0)) {
                    Files.delete(arg0);
                }

                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path arg0, IOException arg1) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path arg0, IOException arg1) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        });
        String parole = "klacnlknwklfw lgkgnerkgnwerkgnq qrogqwerognqwerofgnweriogqweogqweo";

        Files.write(Paths.get("/tmp/test.txt"), parole.getBytes(), StandardOpenOption.CREATE);

        Files.write(Paths.get("/tmp/copiadiecho.txt"), Files.readString(path).getBytes(),
                StandardOpenOption.CREATE);
    }
}
