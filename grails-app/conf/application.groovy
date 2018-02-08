

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'kamocinekfa.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'kamocinekfa.UserAuthority'
grails.plugin.springsecurity.authority.className = 'kamocinekfa.Authority'
grails.plugin.springsecurity.logout.handlerNames = [
		'rememberMeServices', 'securityContextLogoutHandler'
]
grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.successHandler.alwaysUseDefault = true
grails.plugin.springsecurity.successHandler.defaultTargetUrl = '/'
grails.plugin.springsecurity.logout.alwaysUseDefaultTargetUrl = true
grails.plugin.springsecurity.logout.afterLogoutUrl = "/"
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

