namespace java com.javas.thrifts.demo.beans

include './base.thrift'

enum Gender {
	BOY = 1,
	GIRL = 2,
}


struct UserInfo {
    1: required string name,
    3: required Gender gender,
    6: required i32 weight,
}

service DemoService extends base.BaseService{

    string sayHi(1:required UserInfo userInfo);

    string locate();

    string adsRecommendation();
}