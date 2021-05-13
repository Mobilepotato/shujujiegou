package com.atguigu.recursion;

/**
 * date: 2021/5/13 11:57
 *
 * @author zcq
 */
public class MyMiGong {
    public static void main(String[] args) {
        int[][] map=new int[8][7];
        for (int i=0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }
        for (int i=0;i<8;i++){
            map[i][0]=1;
            map[i][6]=1;
        }
        //���õ���
        map[3][1]=1;
        map[3][2]=1;
        map[3][4]=1;
        map[4][4]=1;
        map[5][4]=1;
        map[5][3]=1;
        map[5][2]=1;
        map[5][1]=1;
        System.out.println("�����ͼ");
        for (int i=0; i<8;i++){
            for (int j=0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        setWay(map,1,1);
        System.out.println("�����ͼ");
        for (int i=0; i<8;i++){
            for (int j=0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        }

    //ʹ�õݹ��������С����·
    //˵��
    //1. map ��ʾ��ͼ
    //2. i,j ��ʾ�ӵ�ͼ���ĸ�λ�ÿ�ʼ���� (1,1)
    //3. ���С���ܵ� map[6][5] λ�ã���˵��ͨ·�ҵ�.
    //4. Լ���� ��map[i][j] Ϊ 0 ��ʾ�õ�û���߹� ��Ϊ 1 ��ʾǽ  �� 2 ��ʾͨ·������ �� 3 ��ʾ�õ��Ѿ��߹��������߲�ͨ
    //5. �����Թ�ʱ����Ҫȷ��һ������(����) ��->��->��->�� , ����õ��߲�ͨ���ٻ���
    /**
     *
     * @param map ��ʾ��ͼ
     * @param i ���ĸ�λ�ÿ�ʼ��
     * @param j
     * @return ����ҵ�ͨ·���ͷ���true, ���򷵻�false
     */
        public static boolean setWay(int[][] map,int i,int j){
        if (map[6][5]==2){
            return true;
        }else {
            if (map[i][j]==0){
                //���ղ��� ��->��->��->��  ��
                map[i][j] = 2; // �ٶ��õ��ǿ�����ͨ.
                if (setWay(map,i+1,j)){
                    return true;
                }else if (setWay(map,i,j+1)){
                    return true;
                }else if (setWay(map,i-1,j)){
                    return true;
                }else if (setWay(map,i,j-1)){
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }

            }else {
                return false;
            }
        }

        }
}
