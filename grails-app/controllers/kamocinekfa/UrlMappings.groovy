package kamocinekfa

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "/admin/"(view: "/admin/home")
        "/player/"(view: "/player/home")
        "/coach/"(view: "/coach/home")

        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
