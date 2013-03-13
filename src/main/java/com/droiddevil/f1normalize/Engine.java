package com.droiddevil.f1normalize;

import java.util.List;

import com.droiddevil.f1normalize.normalizer.Normalizer;

public class Engine {

    F1NProtocol mProtocol;

    List<Normalizer> mRules;

    public Engine(F1NProtocol protocol, List<Normalizer> rules) {
        mProtocol = protocol;
    }

}
