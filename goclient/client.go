package main

import (
	"context"
	"fmt"
	"time"

	hessian "github.com/apache/dubbo-go-hessian2"
	_ "github.com/apache/dubbo-go/cluster/cluster_impl"
	_ "github.com/apache/dubbo-go/cluster/loadbalance"
	_ "github.com/apache/dubbo-go/common/proxy/proxy_factory"
	"github.com/apache/dubbo-go/config"
	_ "github.com/apache/dubbo-go/filter/filter_impl"
	_ "github.com/apache/dubbo-go/protocol/dubbo"
	_ "github.com/apache/dubbo-go/registry/protocol"
	_ "github.com/apache/dubbo-go/registry/zookeeper"
)

type User struct {
	Name string
	Age  int32
}

type UserProvider struct {
	GetUser func(ctx context.Context, req []interface{}, rsp *User) error `dubbo:"getUser"`
}

func (u *UserProvider) Reference() string {
	return "UserProvider"
}

func (u User) JavaClassName() string {
	return "me.aki.demo.model.User"
}

var userProvider = new(UserProvider)

// need to setup environment variable "CONF_CONSUMER_FILE_PATH" to "conf/client.yml" before run
func main() {

	config.SetConsumerService(userProvider)
	hessian.RegisterPOJO(User{})

	config.Load()
	time.Sleep(3 * time.Second)

	user := &User{}
	err := userProvider.GetUser(context.TODO(), []interface{}{"A001"}, user)
	if err != nil {
		fmt.Println(err)
		return
	}
	fmt.Printf("response result: %v\n", user)
}
