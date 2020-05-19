package com.eureka.a.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A 接口信令
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ASignalModel implements Serializable {

    private long dataNum;

    private String imsi;

    private short collectNum;

    private short portNum;

    private short slotNum;

    private String timeMs;

    private int kilometer;

    private byte dataWay;

    private int dataLenth;

    private byte sccpMsgType;

    private byte bssmapDtapInd;

    private byte bssmapMsgType;

    private String dataContent;

    private String reserve1;

    private String reserve2;

    private int speed;

    private long callMarkNum;
}
