package bghimport;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

import bghimport.bgh.BghProvider;

public class Main {
    public static void main(final String[] args) {
        // TODO: bessere Parameter-Verwaltung
        try {
            Path path = Paths.get(args[0]);
            final int start = Integer.parseInt(args[1]); // min: 17750
            final int end = Integer.parseInt(args[2]); // max: ~73500

            for (int i = start; i <= end; i++) {
                BghProvider.download(i, path);
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException | InvalidPathException e) {
            System.out.println("Usage: bghdl.jar <path> <start-id> <end-id>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
