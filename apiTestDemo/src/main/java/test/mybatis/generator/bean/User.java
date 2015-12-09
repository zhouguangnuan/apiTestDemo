package test.mybatis.generator.bean;

import java.util.Date;

public class User
{
        private String id;

        private String name;

        private Integer age;

        private Date birthday;

        public User()
        {
                super();
        }

        public User(String id, String name)
        {
                super();
                this.id = id;
                this.name = name;
        }

        public String getId()
        {
                return id;
        }

        public void setId(String id)
        {
                this.id = id == null ? null : id.trim();
        }

        public String getName()
        {
                return name;
        }

        public void setName(String name)
        {
                this.name = name == null ? null : name.trim();
        }

        public Integer getAge()
        {
                return age;
        }

        public void setAge(Integer age)
        {
                this.age = age;
        }

        public Date getBirthday()
        {
                return birthday;
        }

        public void setBirthday(Date birthday)
        {
                this.birthday = birthday;
        }
}