package BSO;

import MetaHeuristics.BasicTabuList;
import MetaHeuristics.TabuList;

/**
 * Created by ressay on 29/03/18.
 */
public abstract class BSOBasic<T> extends BSOAbstract<T>
{
    long maximumIteration;
    long numberOfIterations = 0;
    boolean endS = false;

    public BSOBasic(Dances<T> dances) {
        super(new BasicTabuList<>(100),dances);
        // default number of max iterations
        maximumIteration = 10000;
    }

    public BSOBasic(Dances<T> dances, long maximumIteration) {
        super(new BasicTabuList<>(100),dances);
        this.maximumIteration = maximumIteration;
    }

    @Override
    protected boolean end(T solution) {
        return (numberOfIterations++ >= maximumIteration) || endS;
    }

    protected void endSearch()
    {
        endS = true;
    }

}