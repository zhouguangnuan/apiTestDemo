/**
 * <p>项目名：</p>
 * <p>包名：bean</p>
 * <p>文件名：CollectionBean.java</p>
 * <p>版本信息：</p>
 * <p>日期：2015-5-11-下午10:18:58</p>
 * Copyright (c) 2015singno公司-版权所有
 */
package bean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * <p>名称：CollectionBean.java</p>
 * <p>描述：</p>
 * <pre>
 *    
 * </pre>
 * @author 周光暖
 * @date 2015-5-11 下午10:18:58
 * @version 1.0.0
 */
public class CollectionBase
{  
	/**
	 * 注入实体单元
	 */
	@PersistenceContext(unitName = "collection-entity")
	protected EntityManager em;

	/**
	 * EntityManger 实例化
	 */
	protected EntityManager getEntityManager()
	{
		return this.em;
	}
}  