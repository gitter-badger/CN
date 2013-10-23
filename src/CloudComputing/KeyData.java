package CloudComputing;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class KeyData implements WritableComparable<KeyData> {

	private String phoneId;
	private String date;
	private String cellId;
	
	public KeyData(){}
	
	public KeyData(String phoneId, String date, String cellId){
		this.phoneId = phoneId;
		this.date = date;
		this.cellId = cellId;		
		
	}
	
	public String getPhoneId(){return phoneId;}
	public String getDate(){return date;}
	public String getCellId(){return cellId;}
	
	@Override
	public void readFields(DataInput in) throws IOException {
		phoneId = in.readUTF();
		date = in.readUTF();
		cellId = in.readUTF();
		
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeUTF(phoneId);
		out.writeUTF(date);
		out.writeUTF(cellId);
		
	}

	public int compareTo(KeyData key) {

		String total = phoneId + date + cellId;
		System.out.println(total + " == " + key.phoneId + key.date + key.cellId);
		return total.compareTo(key.phoneId + key.date + key.cellId); 
		
	}

}