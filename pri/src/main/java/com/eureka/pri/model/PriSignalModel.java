package com.eureka.pri.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * PRI 接口信令
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriSignalModel implements Serializable {

    private long dataNum;

    private String msisdn;

    private String engineId;

    private String trainNum;

    private byte ljNum;

    private short deviceNum;

    private short portNum;

    private short slotNum;

    private String timeMs;

    private byte dataWay;

    private short integrality;

    private short frameId;

    private long kilometerMark;

    private int speed;

    private short subType;

    private short l3MsgType;

    private int dataLenth;

    private String dataContent;

    private long referNum;

    private short cause;

    private short sigType;

    private long ctcsId;

    private long lrbgId;

    private long callMarkNum;

    private int timeShort;
}
