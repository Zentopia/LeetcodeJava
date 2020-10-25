package com.utopia.leetcode.week;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class N5547CheckArithmeticSubarrays {
    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        int m = l.length;
        List<Boolean> resArr = new ArrayList<>();

        outerLoop:
        for (int i = 0; i < m; i++){
            int[] arr = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            int min = arr[0];
            int max = arr[0];
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(min, min);
            for (int j = 1; j < arr.length; j++){
                int value = arr[j];
                map.put(value, value);
                if (value < min){
                    min = value;
                }

                if (value > max){
                    max = value;
                }
            }

            int gap = (max - min) / (arr.length - 1);
            if (gap == 0 && map.size() > 1){
                resArr.add(false);
                continue outerLoop;
            }

            int nextValue = min;
            for (int j = 1; j < arr.length; j++){
                nextValue += gap;
                if (map.get(nextValue) == null){
                    resArr.add(false);
                    continue outerLoop;
                }
            }
            resArr.add(true);
        }

        return resArr;
    }

    public static void main(String[] args) {

       int[] nums = new int[]{-342,480,36,90,18,162,54,126,144,108,72,180,930,344,43,215,301,129,387,172,430,258,86,-297,-99,-495,-396,-990,-198,-594,-792,-891,-693,-100,-20,-40,-10,-70,0,0,0,0,0,0,0,0,0,0,3,8,-495,-891,-990,-99,-297,-693,-396,-594,-792,-198,-329,-423,-235,-188,-47,-94,30,3,6,15,27,21,12,24,9,18,-60,-150,-135,-45,-30,585,260,455,237,-365,-292,-730,760,228,608,-46,-108,-102,-700,-420,-210,-280,-350,-630,-560,-140,-490,-70,2,8,10,-120,-30,-75,-105,-45,-135,-90,68,136,238,272,34,306,126,315,378,504,630,252,63,567,189,441,99,88,66,22,55,11,171,190,19,133,114,76,152,57,95,76,164,492,574,328,820,246,656,82,410,738,-25,-35,-15,-10,-45,-20,-30,-5,-40,-42,-54,-12,-980,-588,-490,-392,-360,-648,-216,-432,-144,-72,-288,-720,-576,243,54,-510,-595,-850,-425,-368,-184,-230,-414,-46,-92,-276,-460,-138,-322,-32,-96,-72,70,42,84,28,14,126,56,140,98,112,-217,-656,-820,-328,-250,-200,-75,-150,-225,-125,-50,-25,-100,-175,130,208,48,56,32,-168,-147,-63,-105,-189,-693,-616,-385,-231,-539,-462,-770,-847,-77,-154,-308,405,270,90,225,70,175,-33,-297,-99,-264,-132,-330,-231,-66,-165,-198,385,154,308,616,-570,-855,-285,-380,-190,-665,-760,-95,-540,-216,-432,-54,-324,-486,-108,-162,-270,-378,445,89,-256,-448,-64,-128,-81,-18,-72,-63,-54,-90,-27,-36,-45,-9,680,170,679,460,276,230,184,92,414,322,138,46,368,249,83,-308,-264,-440,-88,-352,-132,-176,-148,-106,100,-870,-783,-522,-174,-261,-435,-609,-696,-87,-348,-194,-97,-776,-485,-873,-291,-388,-970,68,272,306,238,102,340,204,-96,-240,-24,-240,-672,-168,536,402,134,67,335,603,469,201,670,268,-920,-460,-276,-184,-368,160,720,560,240,800,80,400,640,320,480,-147,-84,-42,-210,-189,-63,-126,-168,-21,170,85,153,34,136,490,-170,-102,-272,-68,-204,-141,-376,-47,-470,-550,-275,-220,-330,-495,-110,-55,-440,-385,-165,-80,-200,-360,-240,105,189,168,210,42,147,21,126,84,63,-252,-56,-224,-168,-112,-196,-28,-140,28,-450,-600,-588,-84,-504,-168,-756,-672,-252,-420,-840,-336,-60,-90,-135,-15,-105,-150,-120,-75,86,344,172,129,215,301,387,43,258,430,-675,-225,-750,-150,-450,-75,-315,-175,-350,-24,-28,-32,-16,-8,-36,-20,-40,-4,-12,-315,-360,-45,-90,-450,958};
       int[] l = new int[]{196,131,449,305,145,265,177,439,167,1,322,43,396,2,130,200,52,338,328,284,226,273,208,130,448,437,178,324,70,290,412,370,333,61,326,391,70,187,476,164,157,220,422,93,126,234,415,106,98,167,160,187,312,444,48,235,460,339,207,224,13,140,78,19,424,162,228,49,439,288,62,58,293,414,443,127,367,205,57,49,19,430,34,143,75,74,173,15,330,447,316,19,370,425,309,203,226,55,203,177,361,481,377,437,293,338,423,137,476,158,395,146,389,353,50,107,208,450,67,71,265,238,305,300,92,181,216,332,311,366,372,221,228,389,334,333,373,13,141,318,272,148,289,349,404,139,75,131,400,294,384,171,324,228,16,46,166,323,211,316,173,231,255,249,5,368,229,465,259,219,146,107,213,136,55,251,450,473,442,57,480,295,321,161,182,200,198,188,66,316,189,456,465,357,374,229,221,395,441,194,188,128,59,341,52,100,314,153,78,440,433,384,192,231,402,321,111,274,363,219,433,457,374,414,71,467,355,10,209,210,387,444,370,91,200,93,184,194,38,143,161,334,155,374,25,463,467,133,124,153,21,253,402,107,52,220,192,133,94,425,232,175,418,127,426,67,295,435,190,196,363,172,81,166,178,231,135,249,342,164,461,440,449,259,98,203,191,234,31,313,114,8,375,242,379,145,24,153,171,211,71,121,466,74,427,72,302,434,457,360,158,101,400,276,358,108,95,155,132,178,206,13,252,461,259,119,467,304,23,180,167,401,407,265,128,324,120,132,218,304,396,385,311,33,221,388,131,279,196,341,93,134,312,9,118,443,73,23,457,372,302,297,450,162,83,271,404,171,231,17,470,183,39,60,299,110,450,226,275,332,152,65,271,185,258,119,117,171,124,12,214,128,235,315,185,269,38,304,97,100,322,291,38,59,411,387,22,326,143,93,173,146,100,448,463,443,242,324,122,365,186,285,104,35,89,120,466,163,392,327,54,409,200,400};
       int[] r = new int[]{205,140,458,314,154,268,186,441,176,10,331,52,405,11,139,209,61,347,337,293,235,282,217,139,457,446,187,333,79,299,421,379,342,70,335,400,79,196,485,173,166,229,424,102,135,244,424,115,107,176,169,196,321,453,57,244,469,348,216,233,22,149,87,21,433,171,237,58,448,297,71,67,302,424,452,136,376,214,66,58,28,439,43,152,84,83,182,24,339,456,325,28,379,434,318,212,235,63,212,180,370,490,386,446,302,347,432,146,485,167,404,155,398,362,59,116,217,459,76,80,274,247,314,309,101,190,225,341,320,375,381,230,237,398,343,342,382,22,150,327,281,157,298,358,413,148,84,140,409,303,393,180,333,237,25,55,175,332,220,325,182,240,264,258,14,377,238,474,268,228,155,116,222,145,64,260,459,482,451,66,489,304,330,170,191,209,207,197,75,325,198,464,474,366,383,238,230,404,450,203,197,137,68,350,61,109,323,162,87,446,442,393,201,240,411,330,120,283,372,228,442,466,383,423,80,476,364,19,212,219,396,453,379,100,209,102,193,203,47,152,170,343,164,383,34,472,476,142,133,162,30,262,411,116,59,229,201,142,103,434,241,184,427,136,435,76,304,444,199,205,372,181,90,175,187,240,144,258,351,173,470,449,458,268,107,212,200,243,40,322,123,17,384,251,388,154,33,162,180,220,73,130,470,83,436,81,311,439,466,369,167,110,409,285,367,117,104,164,141,187,215,22,261,470,268,128,476,313,32,189,176,410,416,274,137,333,129,141,227,313,405,394,320,42,230,397,140,288,205,350,102,143,321,18,127,452,82,32,466,381,311,306,459,171,92,280,413,180,240,26,479,192,48,69,308,119,459,235,284,341,154,74,280,194,267,128,126,180,133,21,223,137,244,324,194,278,47,313,106,109,331,300,47,68,420,396,31,335,152,102,180,155,109,457,472,452,251,333,131,374,195,294,113,44,98,129,468,170,401,336,63,418,209,409};

       List<Boolean> res = checkArithmeticSubarrays(nums, l, r);
       boolean[] correctResults = new boolean[] {false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,true,false,false,false,false,false,true,false,false,false,false,false,true,false,false,false,true,false,false,false,false,false,true,true,false,false,false,false,false,false,true,false,false,false,false,false,true,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,true,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,true,false,true,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,true,false,false,false,false,false,false,false,false,false,true,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,true,false,false,false,false,false,true,false,true,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,true,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,true,false,false,false,false,false,false,true,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,true,false,true,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,true,false,false,false,false,false,true,false,false,false,false,false,false,false,false,true,false,false,false,false,false,true,false,false,false,false,false,false,false,true,false,false,false,false,false,false,true,false};

       for (int i = 0; i < res.size(); i++){
           if (res.get(i) != correctResults[i]){
               int[] array = Arrays.copyOfRange(nums, l[i], r[i] + 1);
               System.out.println(Arrays.toString(array));
           }
       }

    }


}