import java.util.List;

/**
 * Created by tommy on 2016/2/18.
 */
public class Railway {
    List<Signal> signals;
    List<Block> blocks;

    public Railway() {
//        this.signals = signals;
//        this.blocks = blocks;
        FileHandler fh = new FileHandler();
        this.signals = fh.getSignal();
        this.blocks = fh.getBlock();

        for (int i = 0; i < signals.size(); i++) {
            Signal s = signals.get(i);
            String flag = s.getFlag()==0?"STOP":"GO";
            String direction = s.getDirection()==0?"DOWN":"UP";
            System.out.println("Signal: "+s.getName()+"("+direction+") controls block: "+s.getBlockName()+" current flag: "+flag);
        }

        for (int i = 0; i < blocks.size(); i++) {
            Block b = blocks.get(i);
            String type = b.getType()==0?"track":"point";
            System.out.println("Block: "+b.getName()+" is a "+type+ " and position is "+b.getPosition());
        }
    }

    public List<Signal> getSignals() {
        return signals;
    }

    public void setSignals(List<Signal> signals) {
        this.signals = signals;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }
}
