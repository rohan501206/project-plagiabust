/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportingModule;

/**
 *
 * @author user
 */
public class DataFetcher

{
public DataFetcher(String tail, String serial, String model,
String engine)
{
setTailNum(tail);
setAircraftSerial(serial);
setAircraftModel(model);
setEngineModel(engine);

}
public DataFetcher()
{
}
private String tailNum;
private String aircraftSerial;
private String aircraftModel;
private String engineModel;


public String getAircraftModel()
{
return aircraftModel;
}


public void setAircraftModel(String aircraftModel)

{
this.aircraftModel = aircraftModel;
}
public String getAircraftSerial()
{
return aircraftSerial;
}
public void setAircraftSerial(String aircraftSerial)
{
this.aircraftSerial = aircraftSerial;
}
public String getEngineModel()
{
return engineModel;
}
public void setEngineModel(String engineModel)
{
this.engineModel = engineModel;
}
public String getTailNum()
{
return tailNum;
}
public void setTailNum(String tailNum)
{
this.tailNum = tailNum;
}
}

