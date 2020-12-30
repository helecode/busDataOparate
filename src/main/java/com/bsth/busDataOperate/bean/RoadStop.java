package com.bsth.busDataOperate.bean;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author 
 * @date 2020-12-25
 */
@Component
public class RoadStop 
{
    private static final long serialVersionUID = 1L;

    /** 行业编码 */
    private String StationStandardCode;

    /** 站点编号 */
    private String StopId;

    /** 环域 */
    private String Area;

    /** 区属 */
    private String District;

    /** 区域 */
    private String Quyu;

    /** 路名 */
    private String RoadName;

    /** 站名 */
    private String StationName;

    /** 车向 */
    private String PathDirection;

    /** 站址 */
    private String StationAddress;

    /** 站点类型 */
    private String StopType;

    /** 停靠线路 */
    private String LineList;

    /** 站点情况 */
    private String StopState;

    /** 人行道宽度 */
    private String SidewalkWidth;

    /** 沿街情况 */
    private String AfterCondition;

    /** 路面材质 */
    private String SurfaceProperty;

    /** 是否主干道 */
    private Integer IsMainRoad;

    /** 附近标志性建筑 */
    private String Landmark;

    /** 可换乘地铁(300 米内) */
    private String RideMetroRoadName;

    /** 主要交通枢纽 */
    private String Transporthub;

    /** 城地坐标 */
    private String CityCoordinate;

    /** 更新日期 */
    private String UpDataTime;

    public void setStationStandardCode(String StationStandardCode) 
    {
        this.StationStandardCode = StationStandardCode;
    }

    public String getStationStandardCode() 
    {
        return StationStandardCode;
    }
    public void setStopId(String StopId) 
    {
        this.StopId = StopId;
    }

    public String getStopId() 
    {
        return StopId;
    }
    public void setArea(String Area) 
    {
        this.Area = Area;
    }

    public String getArea() 
    {
        return Area;
    }
    public void setDistrict(String District) 
    {
        this.District = District;
    }

    public String getDistrict() 
    {
        return District;
    }
    public void setQuyu(String Quyu) 
    {
        this.Quyu = Quyu;
    }

    public String getQuyu() 
    {
        return Quyu;
    }
    public void setRoadName(String RoadName) 
    {
        this.RoadName = RoadName;
    }

    public String getRoadName() 
    {
        return RoadName;
    }
    public void setStationName(String StationName) 
    {
        this.StationName = StationName;
    }

    public String getStationName() 
    {
        return StationName;
    }
    public void setPathDirection(String PathDirection) 
    {
        this.PathDirection = PathDirection;
    }

    public String getPathDirection() 
    {
        return PathDirection;
    }
    public void setStationAddress(String StationAddress) 
    {
        this.StationAddress = StationAddress;
    }

    public String getStationAddress() 
    {
        return StationAddress;
    }
    public void setStopType(String StopType) 
    {
        this.StopType = StopType;
    }

    public String getStopType() 
    {
        return StopType;
    }
    public void setLineList(String LineList) 
    {
        this.LineList = LineList;
    }

    public String getLineList() 
    {
        return LineList;
    }
    public void setStopState(String StopState) 
    {
        this.StopState = StopState;
    }

    public String getStopState() 
    {
        return StopState;
    }
    public void setSidewalkWidth(String SidewalkWidth) 
    {
        this.SidewalkWidth = SidewalkWidth;
    }

    public String getSidewalkWidth() 
    {
        return SidewalkWidth;
    }
    public void setAfterCondition(String AfterCondition) 
    {
        this.AfterCondition = AfterCondition;
    }

    public String getAfterCondition() 
    {
        return AfterCondition;
    }
    public void setSurfaceProperty(String SurfaceProperty) 
    {
        this.SurfaceProperty = SurfaceProperty;
    }

    public String getSurfaceProperty() 
    {
        return SurfaceProperty;
    }
    public void setIsMainRoad(Integer IsMainRoad) 
    {
        this.IsMainRoad = IsMainRoad;
    }

    public Integer getIsMainRoad() 
    {
        return IsMainRoad;
    }
    public void setLandmark(String Landmark) 
    {
        this.Landmark = Landmark;
    }

    public String getLandmark() 
    {
        return Landmark;
    }
    public void setRideMetroRoadName(String RideMetroRoadName) 
    {
        this.RideMetroRoadName = RideMetroRoadName;
    }

    public String getRideMetroRoadName() 
    {
        return RideMetroRoadName;
    }
    public void setTransporthub(String Transporthub) 
    {
        this.Transporthub = Transporthub;
    }

    public String getTransporthub() 
    {
        return Transporthub;
    }
    public void setCityCoordinate(String CityCoordinate) 
    {
        this.CityCoordinate = CityCoordinate;
    }

    public String getCityCoordinate() 
    {
        return CityCoordinate;
    }
    public void setUpDataTime(String UpDataTime) 
    {
        this.UpDataTime = UpDataTime;
    }

    public String getUpDataTime() 
    {
        return UpDataTime;
    }
    
    
	public RoadStop(String stationStandardCode) {
		super();
		StationStandardCode = stationStandardCode;
	}

	public RoadStop() {
		super();
	}

	@Override
	public String toString() {
		return "RoadStop [StationStandardCode=" + StationStandardCode + ", StopId=" + StopId + ", Area=" + Area
				+ ", District=" + District + ", Quyu=" + Quyu + ", RoadName=" + RoadName + ", StationName="
				+ StationName + ", PathDirection=" + PathDirection + ", StationAddress=" + StationAddress
				+ ", StopType=" + StopType + ", LineList=" + LineList + ", StopState=" + StopState + ", SidewalkWidth="
				+ SidewalkWidth + ", AfterCondition=" + AfterCondition + ", SurfaceProperty=" + SurfaceProperty
				+ ", IsMainRoad=" + IsMainRoad + ", Landmark=" + Landmark + ", RideMetroRoadName=" + RideMetroRoadName
				+ ", Transporthub=" + Transporthub + ", CityCoordinate=" + CityCoordinate + ", UpDataTime=" + UpDataTime
				+ "]";
	}
    
}
