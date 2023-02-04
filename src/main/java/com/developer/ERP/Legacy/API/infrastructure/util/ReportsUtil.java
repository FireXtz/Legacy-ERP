package com.developer.ERP.Legacy.API.infrastructure.util;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import org.springframework.util.ObjectUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public final class ReportsUtil {
    private Table table;
    private Document document;
    private PdfDocument pdfDocument;
    private ByteArrayOutputStream byteArrayOutputStream;
    private ReportsUtil(){
        this.byteArrayOutputStream = new ByteArrayOutputStream();
        this.pdfDocument = new PdfDocument(new PdfWriter(this.byteArrayOutputStream));
        this.document = new Document(this.pdfDocument);
    }
    public static ReportsUtil getInstance(){
        return new ReportsUtil();
    }
    public void setPageSize(PageSize pageSize) {
        this.pdfDocument.setDefaultPageSize(pageSize);
    }
    public void addNewLine() {
        this.document.add(new Paragraph("\n"));
    }
    public void addParagraph(Paragraph paragraph) {
        this.document.add(paragraph);
    }
    public void closeDocument() {
        this.document.close();
    }
    public void openTable(Integer columnWidth) {
        this.table = new Table(columnWidth);
        this.table.useAllAvailableWidth();
        this.table.setTextAlignment(TextAlignment.CENTER);
    }
    public void addTableHeader(String... headers) {
        this.validateTable();
        for (String header : headers) {
            this.table.addHeaderCell(header);
        }
    }
    public void addTableColumn(Object column) {
        this.validateTable();
        this.table.addCell(column.toString());
    }
    public void addTableFooter(Object... footers) {
        this.validateTable();
        for (Object footer : footers) {
            this.table.addFooterCell(footer == null ? "" : footer.toString());
        }

        this.table.getFooter().setBackgroundColor(ColorConstants.LIGHT_GRAY);
    }
    public void closeTable() {
        this.validateTable();
        this.document.add(this.table);
    }
    public ByteArrayInputStream getByteArrayInputStream() {
        return new ByteArrayInputStream(this.byteArrayOutputStream.toByteArray());
    }
    private void validateTable() {
        if (ObjectUtils.isEmpty(this.table)) {
            throw new RuntimeException("PDF Table cannot be null.");
        }
    }
}
