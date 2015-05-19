/**
 * <p>项目名：</p>
 * <p>包名：bean</p>
 * <p>文件名：DataFile.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015-5-11-下午11:37:49</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>名称：DataFile.java</p>
 * <p>描述：</p>
 * <pre>
 *    
 * </pre>
 * @author 周光暖
 * @date 2015-5-11 下午11:37:49
 * @version 1.0.0
 */
//@XmlRootElement(name="DataFile")
public class DataFile{
	 
	protected Book book;

	@XmlElement(name = "Book")
	public Book getBook()
	{
		return book;
	}

	public void setBook(Book book)
	{
		this.book = book;
	}
}
