import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
//create class Block
//previous hash: hash code trước đó
//data: 

class Block{
	String prevHash;
	String data;

	//create and convert format date time
	LocalDateTime myDateObj = LocalDateTime.now();
	DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	String date = myDateObj.format(myFormatObj);

	String hash;
	
	// hàm constructor
	Block(String model_prevHash,String model_data){
		prevHash =model_prevHash;
		data = model_data;
		hash = HashCode(prevHash, data, date);	
	}
	public String getHash(){
		return hash;
	}
	public String getInfor(){
		return prevHash + "\t" + data +"\t" + date + "\t" +hash + "\n";
	}
	//hàm hashcode
	static String HashCode(String prevHash, String data, String date){
		//công chuỗi hash trước đó, data và date hiện tại
        String Temp = prevHash + data + date;
        String hashNow = Integer.toString(Temp.hashCode());
        //mine();
		return hashNow;
	}
	
	//gồm các giải thuật để dùng tìm ra hash
	static void mine(){		
        	try {
  				Thread.sleep(2000);
			} catch (InterruptedException e) {
			  	Thread.currentThread().interrupt();
			}
	}

}
interface demoBlockChain{
	public String getLastBlock(); // lấy hash block cuối cùng
	public void addBlock(String data); // thêm block mới
	public boolean isValid();// kiểm tra block có hợp lệ hay không

}


//chứa các block và được liên kết với nhau
class BlockChain implements demoBlockChain{
	// tạo một block bắt đầu
	final Block genesisBlock = new Block("000000", "genesisBlock");

	//tạo một chain để lưu các block
	ArrayList<Block> chain = new ArrayList<Block>();
	BlockChain(){
		chain.add(genesisBlock);
		Block tempblock = new Block(genesisBlock.getHash(), "data 1");
		chain.add(tempblock);
	}
	// hàm trả hash Block cuối cùng
	public String getLastBlock(){
		return chain.get(chain.size() - 1).getHash();
	}

	// thêm block mới
	public void addBlock(String data){
		Block blockNew = new Block(getLastBlock(), data);
		chain.add(blockNew);

	} 

	// hàm trả thông tin của block dưới dạng String
	public String infor(){
		for (int i = 0; i < chain.size() ;i++ ) {
			System.out.print(chain.get(i).getInfor());
		}
		return " ";
	}
	// hàm kiểm tra hai block kế tiếp có hợp lệ hay không
	public boolean isValid(){
		boolean isValid = false;
		if () {
			
		}
		return isValid;
	}



}
class SimpleBlockChain {
	public static void main(String[] args) {

		BlockChain myChain = new BlockChain();
		myChain.addBlock("data 2"); // add thêm data
		System.out.print(myChain.infor());


		// Block myBlock = new Block("0000", "hello world!");
		// System.out.print(myBlock.getNotice());

		// Block myBlock_1 = new Block(myBlock.getHash(), "hello world!");
		// System.out.print(myBlock_1.getNotice());

		// Block myBlock_2 = new Block(myBlock_1.getHash(), "hello world!");
		// System.out.print(myBlock_2.getNotice());

		// Block myBlock_3 = new Block(myBlock_2.getHash(), "hello world!");
		// System.out.print(myBlock_3.getNotice());



	}

}



