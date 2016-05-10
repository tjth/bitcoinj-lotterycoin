/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bitcoinj.params;

import org.bitcoinj.core.Block;

import java.math.BigInteger;

import static com.google.common.base.Preconditions.checkState;

/**
 * Network parameters for 'lottery net' which mimics regression test mode of bitcoind in which 
 * all blocks are trivially solvable. Allows us to connect to hardcoded seeds node tjt12 controls.
 */
public class LotteryNetParams extends RegTestParams {

    public LotteryNetParams() {
        super();
        id = ID_LOTTERYNET;
    }

    public LotteryNetParams(int customPort) {
        super();
        port = customPort;
        id = ID_LOTTERYNET;
    }

    private static LotteryNetParams instance;
    public static synchronized LotteryNetParams get() {
        if (instance == null) {
            instance = new LotteryNetParams();
        }
        return instance;
    }

    public static synchronized LotteryNetParams get(int customPort) {
        if (instance == null) {
            instance = new LotteryNetParams(customPort);
        }
        return instance;
    }

    @Override
    public String getPaymentProtocolId() {
        return PAYMENT_PROTOCOL_ID_LOTTERYNET;
    }
}
