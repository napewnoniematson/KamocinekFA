package kamocinekfa

import com.lowagie.text.Document
import com.lowagie.text.Font
import com.lowagie.text.FontFactory
import com.lowagie.text.PageSize
import com.lowagie.text.Paragraph
import com.lowagie.text.Phrase
import com.lowagie.text.pdf.BaseFont
import com.lowagie.text.pdf.PdfPCell
import com.lowagie.text.pdf.PdfPTable
import com.lowagie.text.pdf.PdfWriter
import grails.plugin.springsecurity.annotation.Secured

import java.text.SimpleDateFormat

@Secured('ROLE_COACH')
class CoachController {

    def springSecurityService

    def index() {}

    def home() {
        def coach = Coach.findByUser(springSecurityService.currentUser)
        [
                coach: coach
        ]
    }

    def showProfile() {
        def coach = Coach.findByUser(springSecurityService.currentUser)
        [
                coach: coach
        ]
    }

    def editProfile() {
        def coach = Coach.findByUser(springSecurityService.currentUser)
        [
                coach: coach,
        ]
    }

    def update() {
        def coach = Coach.findByUser(springSecurityService.currentUser)

        params.put('user', springSecurityService.currentUser)
        def tempCoach = new Coach(params)

        tempCoach.validate()
        if(!tempCoach.hasErrors()) {
            coach.name = tempCoach.name
            coach.lastname = tempCoach.lastname
            coach.email = tempCoach.email
            coach.save(flush: true)
            redirect(controller: 'coach', action: 'showProfile')
        } else {
            render(view: 'editProfile', model: [coach: tempCoach])
        }
    }

    def showCourses() {
        def coach = Coach.findByUser(springSecurityService.currentUser)
        [
                courses: coach?.courses
        ]
    }

    def showCourse(int id) {
        def course = Course.get(id)
        [
                title: course?.title,
                players: course?.players,
                id: id
        ]
    }
    def attendanceList () {

        def coach = Coach.findByUser(springSecurityService.currentUser)
        def course = Course.findById(params.id)
        Document document = new Document()
        String folderName = coach.name + "_" + coach.lastname + ".pdf"
        def file = new File(folderName)
        PdfWriter.getInstance(document, new FileOutputStream(file))
        document.pageSize = PageSize.A4
        final String FONT = "C:\\Windows\\Fonts\\Arial.ttf"
//        Font font = FontFactory.getFont(FontFactory.HELVETICA)
        BaseFont bf = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font font  = new Font(bf, 12)
        document.open()

        document.add(new Paragraph("Imie trenera: " + coach.name, font))
        document.add(new Paragraph("Nazwisko trenera: " + coach.lastname, font))
        document.add(new Paragraph("Nazwa kursu: " + course?.title, font))
        document.add(new Paragraph(" "))

        document.add(new Paragraph("Lista obecności:", font))
        document.add(new Paragraph(" "))
        PdfPTable table = new PdfPTable(4)
        PdfPCell cell = new PdfPCell()


        cell.phrase = new Phrase("Imie", font)
        table.addCell(cell)
        cell.phrase = new Phrase("Nazwisko", font)
        table.addCell(cell)
        cell.phrase = new Phrase("Data", font)
        table.addCell(cell)
        cell.phrase = new Phrase("Podpis", font)
        table.addCell(cell)

        def format = new SimpleDateFormat("dd-MM-yyyy")
        def date = new Date()
        def dateS = format.format(date)

        for (Player player in course?.players) {
            cell.phrase = new Phrase(player?.name, font)
            table.addCell(cell)
            cell.phrase = new Phrase(player?.lastname, font)
            table.addCell(cell)
            cell.phrase = new Phrase(dateS, font)
            table.addCell(cell)
            cell.phrase = new Phrase()
            table.addCell(cell)
        }

        document.add(table)
        document.close()
        render(file: file, contentType: "application/pdf")

    }
}
