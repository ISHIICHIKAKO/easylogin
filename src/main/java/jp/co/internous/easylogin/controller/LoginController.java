package jp.co.internous.easylogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.easylogin.model.domain.MstUser;
import jp.co.internous.easylogin.model.mapper.MstUserMapper;

@Controller
@RequestMapping("/easylogin")
public class LoginController {
	
	/*@Autowiredアノテーションを付与して宣言されたオブジェクトは
	 * Spring Bootによって自動的にインスタンス化される*/
	@Autowired
	private MstUserMapper userMapper;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	/*[RequestMappingと@GetMappingで指定された文字列によって
	 * indexメソッドにアクセスするURLが以下の通り決まる
	 * localhost:8080/easylogin/*/
	
	
	@GetMapping("login")
	public String login(String userName, String password, Model model) {
		
		//mapperを使ってデータベースにアクセス　※MstUserMapperを参照
		MstUser user = userMapper.findByUserNameAndPassword(userName, password);
		
		if(user == null) {
			model.addAttribute("message", "ゲストさん、ようこそ！");
		} else {
			model.addAttribute("message", user.getFullName() + "さん、ようこそ！");
		}
		
		//login.htmlに遷移させる
		return "login";
	}

}
