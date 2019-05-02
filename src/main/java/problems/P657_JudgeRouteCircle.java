package Problems;

/**
 * Created by WangSai on 8/9/18
 */
public class P657_JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        int row = 0;
        int colum = 0;
        for (int i = 0; i < moves.length(); i++) {
            char step = moves.charAt(i);
            switch (step) {
                case 'U':
                    colum++;
                    break;
                case 'D':
                    colum--;
                    break;
                case 'L':
                    row--;
                    break;
                case 'R':
                    row++;
                    break;
                default:
                    return false;
            }
        }
        if (row == 0 && colum == 0) {
            return true;
        } else {
            return false;
        }
    }
}
