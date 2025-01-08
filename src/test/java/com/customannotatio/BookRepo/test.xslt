<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="xml" indent="yes" />
    <xsl:template match="/">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <!-- Page Layout -->
            <fo:layout-master-set>
                <fo:simple-page-master master-name="A4" page-height="29.7cm" page-width="21cm" margin="2cm">
                    <fo:region-body margin-top="4cm" margin-bottom="2cm" />
                    <fo:region-before extent="3cm" />
                    <fo:region-after extent="1cm" />
                </fo:simple-page-master>
            </fo:layout-master-set>

            <!-- Page Content -->
            <fo:page-sequence master-reference="A4">
                <!-- Header -->
                <fo:static-content flow-name="xsl-region-before">
                    <fo:block font-family="Arial" font-size="10pt" color="#000000">
                        <fo:table width="100%">
                            <fo:table-column column-width="50%" />
                            <fo:table-column column-width="50%" />
                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block text-align="left">INTERNAL</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="right">
                                            <fo:external-graphic src="url(logo.png)" content-width="3cm" />
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>
                </fo:static-content>

                <!-- Body -->
                <fo:flow flow-name="xsl-region-body">
                    <!-- Date, Name, and Role -->
                    <fo:block font-family="Arial" font-size="10pt" space-after="10pt">
                        Date: <xsl:value-of select="/data/date" /><br />
                        <xsl:value-of select="/data/recipient/name" /> (<xsl:value-of select="/data/recipient/id" />)<br />
                        <xsl:value-of select="/data/recipient/role" />
                    </fo:block>

                    <!-- Title -->
                    <fo:block font-family="Arial" font-size="14pt" font-weight="bold" text-align="center" space-after="20pt">
                        DELEGATION OF AUTHORITY
                    </fo:block>

                    <!-- Letter Content -->
                    <fo:block font-family="Arial" font-size="10pt" space-after="20pt">
                        <xsl:value-of select="/data/letterContent" />
                    </fo:block>

                    <!-- Table -->
                    <fo:table table-layout="fixed" width="100%" border-collapse="collapse">
                        <!-- Table Columns -->
                        <fo:table-column column-width="20%" />
                        <fo:table-column column-width="20%" />
                        <fo:table-column column-width="20%" />
                        <fo:table-column column-width="20%" />
                        <fo:table-column column-width="20%" />

                        <!-- Table Header -->
                        <fo:table-header>
                            <fo:table-row background-color="#FFFF99">
                                <fo:table-cell>
                                    <fo:block font-family="Arial" font-size="10pt" font-weight="bold">Column 1</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block font-family="Arial" font-size="10pt" font-weight="bold">Column 2</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block font-family="Arial" font-size="10pt" font-weight="bold">Column 3</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block font-family="Arial" font-size="10pt" font-weight="bold">Column 4</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block font-family="Arial" font-size="10pt" font-weight="bold">Column 5</fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-header>

                        <!-- Table Body -->
                        <fo:table-body>
                            <xsl:for-each select="/data/table/row">
                                <fo:table-row>
                                    <xsl:for-each select="cell">
                                        <fo:table-cell border="1pt solid black">
                                            <fo:block font-family="Arial" font-size="10pt">
                                                <xsl:value-of select="." />
                                            </fo:block>
                                        </fo:table-cell>
                                    </xsl:for-each>
                                </fo:table-row>
                            </xsl:for-each>
                        </fo:table-body>
                    </fo:table>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>