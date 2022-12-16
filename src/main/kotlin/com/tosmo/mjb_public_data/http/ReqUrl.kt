package com.tosmo.mjb_public_data.http

import com.tosmo.mjb_public_data.http.ReqUrl.Customer.ADD_ONE
import com.tosmo.mjb_public_data.http.ReqUrl.Customer.MODIFY
import com.tosmo.mjb_public_data.http.ReqUrl.Customer.SEARCH_CUSTOMER
import com.tosmo.mjb_public_data.http.ReqUrl.Customer.SEARCH_ORGAN
import com.tosmo.mjb_public_data.http.ReqUrl.Setup.SEARCH_GROUP
import com.tosmo.mjb_public_data.http.ReqUrl.Setup.SEARCH_ITEM
import kotlin.reflect.KProperty1
import kotlin.reflect.KVisibility
import kotlin.reflect.full.declaredMemberProperties

/**
 * request url
 */
object ReqUrl {

    /**
     * 检查唯一性，返回秒
     */
    internal fun checkUnique(): Float {
        val start = System.currentTimeMillis()
        val pubProps = ReqUrl::class.declaredMemberProperties.filter { it.visibility == KVisibility.PUBLIC }
        val map = mutableMapOf<String, KProperty1<ReqUrl, *>>()
        pubProps.forEach {
            val v = it.getter.call(ReqUrl) as String
            require(v in map) { "${it.name}的路径与${map[v]}的路径相同" }
            map[v] = it
        }
        val end = System.currentTimeMillis()
        return (end - start) / 1000f
    }

    internal const val PREFIX = "/mjb"

    /**
     * @property SEARCH_ITEM
     * @property SEARCH_GROUP
     */
    object Setup {
        internal const val PREFIX = "${ReqUrl.PREFIX}/setup"

        /**
         * 查设置项
         */
        const val SEARCH_ITEM: String = "$PREFIX/search-item"

        /**
         * 查设置项组
         */
        const val SEARCH_GROUP: String = "$PREFIX/search-group"
    }

    /**
     * @property ADD_ONE
     * @property MODIFY
     * @property SEARCH_ORGAN
     * @property SEARCH_CUSTOMER
     */
    object Customer {

        internal const val PREFIX = "${ReqUrl.PREFIX}/customer"

        /**
         * 新增一个顾客
         */
        const val ADD_ONE = "$PREFIX/add"

        /**
         * 修改顾客信息
         */
        const val MODIFY = "$PREFIX/modify"

        /**
         * 查询机构下的顾客
         */
        const val SEARCH_ORGAN = "$PREFIX/search-organ"

        /**
         * 查询顾客信息
         */
        const val SEARCH_CUSTOMER = "$PREFIX/search-id"

        object Grade {

            internal const val PREFIX = "${Customer.PREFIX}/grade"

            /**
             * 添加一条顾客等级
             */
            const val ADD_ONE = "${PREFIX}/add"

            /**
             * 添加多个顾客等级
             */
            const val ADD_MULTI = "${PREFIX}/add-multi"

            /**
             * 修改顾客等级
             */
            const val MODIFY = "${PREFIX}/modify"

            /**
             * 查询机构的顾客等级
             */
            const val SEARCH_ORGAN = "${PREFIX}/search-organ"

            /**
             * 复制默认的会员等级到机构中
             */
            const val COPY_DEFAULT = "${PREFIX}/copy-default"
        }

        object Origin {

            internal const val PREFIX = "${ReqUrl.PREFIX}${Customer.PREFIX}/origin"

            /**
             * 新增一个顾客来源
             */
            const val ADD_ONE = "$PREFIX/add"

            /**
             * 新增多个顾客来源
             */
            const val ADD_MULTI = "$PREFIX/add-multi"

            /**
             * 查询机构下的顾客来源
             */
            const val SEARCH_ORGAN = "$PREFIX/search-organ"

            /**
             * 复制默认的顾客来源到机构
             */
            const val COPY_DEFAULT = "$PREFIX/copy-default"
        }
    }

    object Organ {

        internal const val PREFIX = "${ReqUrl.PREFIX}/organ"

        /**
         * 查询下级机构
         */
        const val SEARCH_SUBUNITS = "$PREFIX/search-subunits"

    }

    object User {

        internal const val PREFIX = "${ReqUrl.PREFIX}/user"

        /**
         * 账号密码验证
         */
        const val AUTH = "$PREFIX/auth"

        /**
         * 用户登录
         */
        const val LOGIN = "$PREFIX/login"

        /**
         * 用户退出
         */
        const val LOGOUT = "$PREFIX/logout"

        /**
         * 查询用户信息
         */
        const val SEARCH_USER = "$PREFIX/search-user"
    }

}