package kamocinekfa

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "/admin/"(view: "/notFound")
        "/player/"(view: "/notFound")
        "/coach/"(view: "/notFound")

        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
