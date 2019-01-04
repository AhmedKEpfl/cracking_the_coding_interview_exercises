package geeks_for_geeks;

import java.util.ArrayList;
import java.util.List;

public class MatrixMultiplicationOptimization {
    private static class Result {
        int parenthesisPos, nbOperations;
        public Result(int parenthesisPos, int nbOperations) {
            this.parenthesisPos = parenthesisPos;
            this.nbOperations = nbOperations;
        }

        @Override
        public String toString() {
            return "(" + parenthesisPos + ", " + nbOperations + ")";
        }
    }

    public static void main(String[] args) {
        List<List<Result>> memo = optimizeMultiplication(new int[]{ 1, 2, 3, 4, 3 });

        System.out.println(addParenthesis("ABCD", memo));
    }

    public static String getOptimalParenthesization(int[] dims) {
        List<List<Result>> memo = optimizeMultiplication(dims);
        String s = "";
        for(int i = 0; i < dims.length - 1; i++) {
            s += (char)(35 + i);
        }
        return addParenthesis(s, memo);
    }

    private static int getAlphabetRank(char c) {
        return (int)c - (int)'A';
    }

    public static String addParenthesis(String expression, List<List<Result>> memo) {
        int length = expression.length();
        if(expression.length() == 1) {
            return expression;
        }
        int i = length - 1;
        int j = getAlphabetRank(expression.charAt(0));
        int p = memo.get(i).get(j).parenthesisPos;
        String left = expression.substring(0, p);
        String right = expression.substring(p);
        return "(" + addParenthesis(left, memo) + addParenthesis(right, memo) + ")";
    }

    public static List<List<Result>> optimizeMultiplication(int[] dims) {
        List<List<Result>> memo = new ArrayList<List<Result>>();

        List<Result> baseCaseResults = new ArrayList<Result>();
        for(int i = 0; i < dims.length - 1; i++) {
            baseCaseResults.add(new Result(-1, 0));
        }

        memo.add(baseCaseResults);

        for(int i = 1; i < dims.length - 1; i++) {
            List<Result> levelResult = new ArrayList<Result>();
            int resultSize = i + 1;
            for(int j = 0; j < dims.length - resultSize; j++) {
                // Where to put the parenthesis:
                Result result = getBestResult(i, j, dims, memo);
                levelResult.add(result);
            }
            memo.add(levelResult);
        }

        return memo;
    }

    public static Result getBestResult(int i, int j, int[] dims, List<List<Result>> memo) {
        int resultSize = i + 1;
        Result bestResult = new Result(-1, Integer.MAX_VALUE);
        for(int p = 1; p < resultSize; p++) {
            Result currentResult = getResult(i, j, p, dims, memo);
            if(currentResult.nbOperations < bestResult.nbOperations) {
                bestResult = currentResult;
            }
        }

        System.out.println("Best result for (" + i + ", " + j + "): " + bestResult);
        return bestResult;
    }

    public static Result getResult(int i, int j, int p, int[] dims, List<List<Result>> memo) {
        int resultSize = i + 1;
        int leftSize = p;
        int rightSize = resultSize - p;
        int leftRow = leftSize - 1;
        int rightRow = rightSize - 1;
        int leftCol = j;
        int rightCol = j + p;

        int leftNbOperations = memo.get(leftRow).get(leftCol).nbOperations;
        System.out.print(leftNbOperations + " + ");
        int rightNbOperations = memo.get(rightRow).get(rightCol).nbOperations;
        int combineNbOps = dims[j] * dims[j + p] * dims[j + resultSize];

        System.out.print("(" + dims[j] + " * " + dims[j + p] + " * " + dims[j + resultSize] + ") + ");
        System.out.println(leftNbOperations);
        return new Result(p, leftNbOperations + combineNbOps + rightNbOperations);
    }
}
