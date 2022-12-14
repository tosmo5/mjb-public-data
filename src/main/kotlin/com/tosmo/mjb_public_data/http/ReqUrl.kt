package com.tosmo.mjb_public_data.http

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

    // setup

    private const val SETUP_PREFIX = "/mjb/setup"

    /**
     * 查设置项
     */
    const val SETUP_SEARCH_ITEM: String = "${SETUP_PREFIX}/search-item"

    /**
     * 查设置项组
     */
    const val SETUP_SEARCH_GROUP: String = "${SETUP_PREFIX}/search-group"


    // customer grade

    private const val CUSTOMER_GRADE_PREFIX = "/mjb/customer-grade"

    /**
     * 添加一条顾客等级
     */
    const val CUSTOMER_GRADE_ADD_ONE = "${CUSTOMER_GRADE_PREFIX}/add"

    /**
     * 添加多个顾客等级
     */
    const val CUSTOMER_GRADE_ADD_MULTI = "${CUSTOMER_GRADE_PREFIX}/add-multi"

    /**
     * 修改顾客等级
     */
    const val CUSTOMER_GRADE_MODIFY = "${CUSTOMER_GRADE_PREFIX}/modify"

    /**
     * 查询机构的顾客等级
     */
    const val CUSTOMER_GRADE_SEARCH_ORGAN = "${CUSTOMER_GRADE_PREFIX}/search-organ"

    /**
     * 复制默认的会员等级到机构中
     */
    const val CUSTOMER_GRADE_COPY_DEFAULT = "${CUSTOMER_GRADE_PREFIX}/copy-default"

    // customer origin

    private const val CUSTOMER_ORIGIN_PREFIX = "/mjb/customer-origin"

    /**
     * 新增一个顾客来源
     */
    const val CUSTOMER_ORIGIN_ADD_ONE = "${CUSTOMER_ORIGIN_PREFIX}/add"

    /**
     * 新增多个顾客来源
     */
    const val CUSTOMER_ORIGIN_ADD_MULTI = "${CUSTOMER_ORIGIN_PREFIX}/add-multi"

    /**
     * 查询机构下的顾客来源
     */
    const val CUSTOMER_ORIGIN_SEARCH_ORGAN = "${CUSTOMER_ORIGIN_PREFIX}/search-organ"

    /**
     * 复制默认的顾客来源到机构
     */
    const val CUSTOMER_ORIGIN_COPY_DEFAULT = "${CUSTOMER_ORIGIN_PREFIX}/copy-default"

    // organ

    private const val ORGAN_PREFIX = "/mjb/organ"

    /**
     * 查询下级机构
     */
    const val ORGAN_SEARCH_SUBUNITS = "${ORGAN_PREFIX}/search-subunits"


    // user

    private const val USER_PREFIX = "/mjb/user"

    /**
     * 账号密码验证
     */
    const val USER_AUTH = "${USER_PREFIX}/auth"

    /**
     * 用户登录
     */
    const val USER_LOGIN = "${USER_PREFIX}/login"

    /**
     * 用户退出
     */
    const val USER_LOGOUT = "${USER_PREFIX}/logout"

    /**
     * 查询用户信息
     */
    const val USER_SEARCH_USER = "${USER_PREFIX}/search-user"
}