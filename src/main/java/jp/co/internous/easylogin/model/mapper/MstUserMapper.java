package jp.co.internous.easylogin.model.mapper;
/*Mapperインターフェース＝DAO(Data Access Object)
 * データベースにアクセスする役割
 * Mybatisではentity(domain)を介してデータベースにアクセスする*/

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import jp.co.internous.easylogin.model.domain.MstUser;

@Mapper
public interface MstUserMapper {
	
	//発行するSQLがSELECT文の場合、@Selectアノテーションを付与
	//@Selectアノテーションの（）内にSQLを記載
	//メソッドの引数として受け取った変数をSQL内で使うことができる　#{変数名}と記述
	//ここでは#{userName}がString userName、#{password}がString password
	@Select("SELECT * FROM mst_user WHERE user_name = #{userName} AND password = #{password}")
	MstUser findByUserNameAndPassword(String userName, String password);

}
