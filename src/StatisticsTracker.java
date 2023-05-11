import Global.Statistics;

import java.util.List;

import Modele.Arbre;
import Modele.Arbre2;
import Modele.Coup;
import Modele.Jeu;

public class StatisticsTracker {
    public static void main(String[] args) {
        for(int depth = 3; depth <7; depth++){
            double total = generateDepthAverage2(depth, false);
            double totalWithAlphaBeta = generateDepthAverage2(depth, true);
            System.out.println("Average number of configs(without alpha/beta) with depth " + depth + " is: " + total);
            System.out.println("Average number of configs(with alpha/beta) with depth " + depth + " is: " + totalWithAlphaBeta);
            System.out.println("");
        }
    }

    static double generateDepthAverage(int depth){
        for(int i = 0; i < 100; i++){
            Jeu jeu = new Jeu();
            jeu.getInfoJoueurs()[0].setSorcierIndice(0);
            jeu.getInfoJoueurs()[1].setSorcierIndice(0);
            jeu.setEtape(1);

            Arbre arbre = new Arbre(jeu);

            Statistics.setCurrentDepthTotalConfigurations(0);
            arbre.create(depth);
            Statistics.addDepth(depth, Statistics.currentDepthTotalConfigurations, false);
        }
        double total = Statistics.getAverageForDepth(depth, false);
        return total;
    }

    static double generateDepthAverage2(int depth, boolean withAlphaBeta){
        for(int i = 0; i < 100; i++){
            Jeu jeu = new Jeu();
            jeu.getInfoJoueurs()[0].setSorcierIndice(0);
            jeu.getInfoJoueurs()[1].setSorcierIndice(0);
            jeu.setEtape(1);

            Arbre2 arbre2 = new Arbre2(jeu, null, true);

            Statistics.setCurrentDepthTotalConfigurations(0);
            if(withAlphaBeta) arbre2.getCoup(depth, true);
            else arbre2.getCoup(depth, false);
            Statistics.addDepth(depth, Statistics.currentDepthTotalConfigurations, withAlphaBeta);
        }
        double total = Statistics.getAverageForDepth(depth, withAlphaBeta);
        return total;
    }

}
