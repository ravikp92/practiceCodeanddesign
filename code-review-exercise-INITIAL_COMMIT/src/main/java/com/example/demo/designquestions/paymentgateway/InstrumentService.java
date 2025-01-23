package src.main.java.com.example.demo.designquestions.paymentgateway;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class InstrumentService {

    static Map<Integer, List<Instrument>> listMap = new HashMap<>();

    public abstract InstrumentDO addInstrument(InstrumentDO instrumentDO);

    public abstract List<InstrumentDO> getInstrumentByUserId(int  userId);

}
