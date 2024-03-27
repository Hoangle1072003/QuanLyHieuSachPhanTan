package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the {@code libs} extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final ComLibraryAccessors laccForComLibraryAccessors = new ComLibraryAccessors(owner);
    private final NetLibraryAccessors laccForNetLibraryAccessors = new NetLibraryAccessors(owner);
    private final OrgLibraryAccessors laccForOrgLibraryAccessors = new OrgLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Group of libraries at <b>com</b>
     */
    public ComLibraryAccessors getCom() {
        return laccForComLibraryAccessors;
    }

    /**
     * Group of libraries at <b>net</b>
     */
    public NetLibraryAccessors getNet() {
        return laccForNetLibraryAccessors;
    }

    /**
     * Group of libraries at <b>org</b>
     */
    public OrgLibraryAccessors getOrg() {
        return laccForOrgLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class ComLibraryAccessors extends SubDependencyFactory {
        private final ComItextpdfLibraryAccessors laccForComItextpdfLibraryAccessors = new ComItextpdfLibraryAccessors(owner);
        private final ComMicrosoftLibraryAccessors laccForComMicrosoftLibraryAccessors = new ComMicrosoftLibraryAccessors(owner);
        private final ComToedterLibraryAccessors laccForComToedterLibraryAccessors = new ComToedterLibraryAccessors(owner);

        public ComLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.itextpdf</b>
         */
        public ComItextpdfLibraryAccessors getItextpdf() {
            return laccForComItextpdfLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.microsoft</b>
         */
        public ComMicrosoftLibraryAccessors getMicrosoft() {
            return laccForComMicrosoftLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.toedter</b>
         */
        public ComToedterLibraryAccessors getToedter() {
            return laccForComToedterLibraryAccessors;
        }

    }

    public static class ComItextpdfLibraryAccessors extends SubDependencyFactory {

        public ComItextpdfLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>itextpdf</b> with <b>com.itextpdf:itextpdf</b> coordinates and
         * with version reference <b>com.itextpdf.itextpdf</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getItextpdf() {
            return create("com.itextpdf.itextpdf");
        }

    }

    public static class ComMicrosoftLibraryAccessors extends SubDependencyFactory {
        private final ComMicrosoftSqlserverLibraryAccessors laccForComMicrosoftSqlserverLibraryAccessors = new ComMicrosoftSqlserverLibraryAccessors(owner);

        public ComMicrosoftLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.microsoft.sqlserver</b>
         */
        public ComMicrosoftSqlserverLibraryAccessors getSqlserver() {
            return laccForComMicrosoftSqlserverLibraryAccessors;
        }

    }

    public static class ComMicrosoftSqlserverLibraryAccessors extends SubDependencyFactory {
        private final ComMicrosoftSqlserverMssqlLibraryAccessors laccForComMicrosoftSqlserverMssqlLibraryAccessors = new ComMicrosoftSqlserverMssqlLibraryAccessors(owner);

        public ComMicrosoftSqlserverLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.microsoft.sqlserver.mssql</b>
         */
        public ComMicrosoftSqlserverMssqlLibraryAccessors getMssql() {
            return laccForComMicrosoftSqlserverMssqlLibraryAccessors;
        }

    }

    public static class ComMicrosoftSqlserverMssqlLibraryAccessors extends SubDependencyFactory {

        public ComMicrosoftSqlserverMssqlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jdbc</b> with <b>com.microsoft.sqlserver:mssql-jdbc</b> coordinates and
         * with version reference <b>com.microsoft.sqlserver.mssql.jdbc</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJdbc() {
            return create("com.microsoft.sqlserver.mssql.jdbc");
        }

    }

    public static class ComToedterLibraryAccessors extends SubDependencyFactory {

        public ComToedterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jcalendar</b> with <b>com.toedter:jcalendar</b> coordinates and
         * with version reference <b>com.toedter.jcalendar</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJcalendar() {
            return create("com.toedter.jcalendar");
        }

    }

    public static class NetLibraryAccessors extends SubDependencyFactory {
        private final NetSfLibraryAccessors laccForNetSfLibraryAccessors = new NetSfLibraryAccessors(owner);

        public NetLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>net.sf</b>
         */
        public NetSfLibraryAccessors getSf() {
            return laccForNetSfLibraryAccessors;
        }

    }

    public static class NetSfLibraryAccessors extends SubDependencyFactory {
        private final NetSfJasperreportsLibraryAccessors laccForNetSfJasperreportsLibraryAccessors = new NetSfJasperreportsLibraryAccessors(owner);

        public NetSfLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>net.sf.jasperreports</b>
         */
        public NetSfJasperreportsLibraryAccessors getJasperreports() {
            return laccForNetSfJasperreportsLibraryAccessors;
        }

    }

    public static class NetSfJasperreportsLibraryAccessors extends SubDependencyFactory {

        public NetSfJasperreportsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jasperreports</b> with <b>net.sf.jasperreports:jasperreports</b> coordinates and
         * with version reference <b>net.sf.jasperreports.jasperreports</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJasperreports() {
            return create("net.sf.jasperreports.jasperreports");
        }

    }

    public static class OrgLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheLibraryAccessors laccForOrgApacheLibraryAccessors = new OrgApacheLibraryAccessors(owner);
        private final OrgJfreeLibraryAccessors laccForOrgJfreeLibraryAccessors = new OrgJfreeLibraryAccessors(owner);
        private final OrgKordampLibraryAccessors laccForOrgKordampLibraryAccessors = new OrgKordampLibraryAccessors(owner);
        private final OrgMindrotLibraryAccessors laccForOrgMindrotLibraryAccessors = new OrgMindrotLibraryAccessors(owner);
        private final OrgSpringframeworkLibraryAccessors laccForOrgSpringframeworkLibraryAccessors = new OrgSpringframeworkLibraryAccessors(owner);

        public OrgLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache</b>
         */
        public OrgApacheLibraryAccessors getApache() {
            return laccForOrgApacheLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.jfree</b>
         */
        public OrgJfreeLibraryAccessors getJfree() {
            return laccForOrgJfreeLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.kordamp</b>
         */
        public OrgKordampLibraryAccessors getKordamp() {
            return laccForOrgKordampLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.mindrot</b>
         */
        public OrgMindrotLibraryAccessors getMindrot() {
            return laccForOrgMindrotLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.springframework</b>
         */
        public OrgSpringframeworkLibraryAccessors getSpringframework() {
            return laccForOrgSpringframeworkLibraryAccessors;
        }

    }

    public static class OrgApacheLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheCommonsLibraryAccessors laccForOrgApacheCommonsLibraryAccessors = new OrgApacheCommonsLibraryAccessors(owner);
        private final OrgApacheLoggingLibraryAccessors laccForOrgApacheLoggingLibraryAccessors = new OrgApacheLoggingLibraryAccessors(owner);
        private final OrgApacheMavenLibraryAccessors laccForOrgApacheMavenLibraryAccessors = new OrgApacheMavenLibraryAccessors(owner);
        private final OrgApachePoiLibraryAccessors laccForOrgApachePoiLibraryAccessors = new OrgApachePoiLibraryAccessors(owner);

        public OrgApacheLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.commons</b>
         */
        public OrgApacheCommonsLibraryAccessors getCommons() {
            return laccForOrgApacheCommonsLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.apache.logging</b>
         */
        public OrgApacheLoggingLibraryAccessors getLogging() {
            return laccForOrgApacheLoggingLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.apache.maven</b>
         */
        public OrgApacheMavenLibraryAccessors getMaven() {
            return laccForOrgApacheMavenLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.apache.poi</b>
         */
        public OrgApachePoiLibraryAccessors getPoi() {
            return laccForOrgApachePoiLibraryAccessors;
        }

    }

    public static class OrgApacheCommonsLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheCommonsCommonsLibraryAccessors laccForOrgApacheCommonsCommonsLibraryAccessors = new OrgApacheCommonsCommonsLibraryAccessors(owner);

        public OrgApacheCommonsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.commons.commons</b>
         */
        public OrgApacheCommonsCommonsLibraryAccessors getCommons() {
            return laccForOrgApacheCommonsCommonsLibraryAccessors;
        }

    }

    public static class OrgApacheCommonsCommonsLibraryAccessors extends SubDependencyFactory {

        public OrgApacheCommonsCommonsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>lang3</b> with <b>org.apache.commons:commons-lang3</b> coordinates and
         * with version reference <b>org.apache.commons.commons.lang3</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getLang3() {
            return create("org.apache.commons.commons.lang3");
        }

    }

    public static class OrgApacheLoggingLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheLoggingLog4jLibraryAccessors laccForOrgApacheLoggingLog4jLibraryAccessors = new OrgApacheLoggingLog4jLibraryAccessors(owner);

        public OrgApacheLoggingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.logging.log4j</b>
         */
        public OrgApacheLoggingLog4jLibraryAccessors getLog4j() {
            return laccForOrgApacheLoggingLog4jLibraryAccessors;
        }

    }

    public static class OrgApacheLoggingLog4jLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheLoggingLog4jLog4jLibraryAccessors laccForOrgApacheLoggingLog4jLog4jLibraryAccessors = new OrgApacheLoggingLog4jLog4jLibraryAccessors(owner);

        public OrgApacheLoggingLog4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.logging.log4j.log4j</b>
         */
        public OrgApacheLoggingLog4jLog4jLibraryAccessors getLog4j() {
            return laccForOrgApacheLoggingLog4jLog4jLibraryAccessors;
        }

    }

    public static class OrgApacheLoggingLog4jLog4jLibraryAccessors extends SubDependencyFactory {

        public OrgApacheLoggingLog4jLog4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>org.apache.logging.log4j:log4j-core</b> coordinates and
         * with version reference <b>org.apache.logging.log4j.log4j.core</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("org.apache.logging.log4j.log4j.core");
        }

    }

    public static class OrgApacheMavenLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheMavenPluginsLibraryAccessors laccForOrgApacheMavenPluginsLibraryAccessors = new OrgApacheMavenPluginsLibraryAccessors(owner);

        public OrgApacheMavenLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.maven.plugins</b>
         */
        public OrgApacheMavenPluginsLibraryAccessors getPlugins() {
            return laccForOrgApacheMavenPluginsLibraryAccessors;
        }

    }

    public static class OrgApacheMavenPluginsLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheMavenPluginsMavenLibraryAccessors laccForOrgApacheMavenPluginsMavenLibraryAccessors = new OrgApacheMavenPluginsMavenLibraryAccessors(owner);

        public OrgApacheMavenPluginsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.maven.plugins.maven</b>
         */
        public OrgApacheMavenPluginsMavenLibraryAccessors getMaven() {
            return laccForOrgApacheMavenPluginsMavenLibraryAccessors;
        }

    }

    public static class OrgApacheMavenPluginsMavenLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheMavenPluginsMavenJarLibraryAccessors laccForOrgApacheMavenPluginsMavenJarLibraryAccessors = new OrgApacheMavenPluginsMavenJarLibraryAccessors(owner);

        public OrgApacheMavenPluginsMavenLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.maven.plugins.maven.jar</b>
         */
        public OrgApacheMavenPluginsMavenJarLibraryAccessors getJar() {
            return laccForOrgApacheMavenPluginsMavenJarLibraryAccessors;
        }

    }

    public static class OrgApacheMavenPluginsMavenJarLibraryAccessors extends SubDependencyFactory {

        public OrgApacheMavenPluginsMavenJarLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>plugin</b> with <b>org.apache.maven.plugins:maven-jar-plugin</b> coordinates and
         * with version reference <b>org.apache.maven.plugins.maven.jar.plugin</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getPlugin() {
            return create("org.apache.maven.plugins.maven.jar.plugin");
        }

    }

    public static class OrgApachePoiLibraryAccessors extends SubDependencyFactory {
        private final OrgApachePoiPoiLibraryAccessors laccForOrgApachePoiPoiLibraryAccessors = new OrgApachePoiPoiLibraryAccessors(owner);

        public OrgApachePoiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.poi.poi</b>
         */
        public OrgApachePoiPoiLibraryAccessors getPoi() {
            return laccForOrgApachePoiPoiLibraryAccessors;
        }

    }

    public static class OrgApachePoiPoiLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public OrgApachePoiPoiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>poi</b> with <b>org.apache.poi:poi</b> coordinates and
         * with version reference <b>org.apache.poi.poi</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("org.apache.poi.poi");
        }

        /**
         * Dependency provider for <b>ooxml</b> with <b>org.apache.poi:poi-ooxml</b> coordinates and
         * with version reference <b>org.apache.poi.poi.ooxml</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getOoxml() {
            return create("org.apache.poi.poi.ooxml");
        }

    }

    public static class OrgJfreeLibraryAccessors extends SubDependencyFactory {

        public OrgJfreeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jfreechart</b> with <b>org.jfree:jfreechart</b> coordinates and
         * with version reference <b>org.jfree.jfreechart</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJfreechart() {
            return create("org.jfree.jfreechart");
        }

    }

    public static class OrgKordampLibraryAccessors extends SubDependencyFactory {
        private final OrgKordampIkonliLibraryAccessors laccForOrgKordampIkonliLibraryAccessors = new OrgKordampIkonliLibraryAccessors(owner);

        public OrgKordampLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.kordamp.ikonli</b>
         */
        public OrgKordampIkonliLibraryAccessors getIkonli() {
            return laccForOrgKordampIkonliLibraryAccessors;
        }

    }

    public static class OrgKordampIkonliLibraryAccessors extends SubDependencyFactory {
        private final OrgKordampIkonliIkonliLibraryAccessors laccForOrgKordampIkonliIkonliLibraryAccessors = new OrgKordampIkonliIkonliLibraryAccessors(owner);

        public OrgKordampIkonliLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.kordamp.ikonli.ikonli</b>
         */
        public OrgKordampIkonliIkonliLibraryAccessors getIkonli() {
            return laccForOrgKordampIkonliIkonliLibraryAccessors;
        }

    }

    public static class OrgKordampIkonliIkonliLibraryAccessors extends SubDependencyFactory {
        private final OrgKordampIkonliIkonliMaterialdesignLibraryAccessors laccForOrgKordampIkonliIkonliMaterialdesignLibraryAccessors = new OrgKordampIkonliIkonliMaterialdesignLibraryAccessors(owner);

        public OrgKordampIkonliIkonliLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>swing</b> with <b>org.kordamp.ikonli:ikonli-swing</b> coordinates and
         * with version reference <b>org.kordamp.ikonli.ikonli.swing</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSwing() {
            return create("org.kordamp.ikonli.ikonli.swing");
        }

        /**
         * Group of libraries at <b>org.kordamp.ikonli.ikonli.materialdesign</b>
         */
        public OrgKordampIkonliIkonliMaterialdesignLibraryAccessors getMaterialdesign() {
            return laccForOrgKordampIkonliIkonliMaterialdesignLibraryAccessors;
        }

    }

    public static class OrgKordampIkonliIkonliMaterialdesignLibraryAccessors extends SubDependencyFactory {

        public OrgKordampIkonliIkonliMaterialdesignLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>pack</b> with <b>org.kordamp.ikonli:ikonli-materialdesign-pack</b> coordinates and
         * with version reference <b>org.kordamp.ikonli.ikonli.materialdesign.pack</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getPack() {
            return create("org.kordamp.ikonli.ikonli.materialdesign.pack");
        }

    }

    public static class OrgMindrotLibraryAccessors extends SubDependencyFactory {

        public OrgMindrotLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jbcrypt</b> with <b>org.mindrot:jbcrypt</b> coordinates and
         * with version reference <b>org.mindrot.jbcrypt</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJbcrypt() {
            return create("org.mindrot.jbcrypt");
        }

    }

    public static class OrgSpringframeworkLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkSecurityLibraryAccessors laccForOrgSpringframeworkSecurityLibraryAccessors = new OrgSpringframeworkSecurityLibraryAccessors(owner);

        public OrgSpringframeworkLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.security</b>
         */
        public OrgSpringframeworkSecurityLibraryAccessors getSecurity() {
            return laccForOrgSpringframeworkSecurityLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkSecurityLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkSecuritySpringLibraryAccessors laccForOrgSpringframeworkSecuritySpringLibraryAccessors = new OrgSpringframeworkSecuritySpringLibraryAccessors(owner);

        public OrgSpringframeworkSecurityLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.security.spring</b>
         */
        public OrgSpringframeworkSecuritySpringLibraryAccessors getSpring() {
            return laccForOrgSpringframeworkSecuritySpringLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkSecuritySpringLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkSecuritySpringSecurityLibraryAccessors laccForOrgSpringframeworkSecuritySpringSecurityLibraryAccessors = new OrgSpringframeworkSecuritySpringSecurityLibraryAccessors(owner);

        public OrgSpringframeworkSecuritySpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.security.spring.security</b>
         */
        public OrgSpringframeworkSecuritySpringSecurityLibraryAccessors getSecurity() {
            return laccForOrgSpringframeworkSecuritySpringSecurityLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkSecuritySpringSecurityLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkSecuritySpringSecurityLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>org.springframework.security:spring-security-core</b> coordinates and
         * with version reference <b>org.springframework.security.spring.security.core</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("org.springframework.security.spring.security.core");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final ComVersionAccessors vaccForComVersionAccessors = new ComVersionAccessors(providers, config);
        private final NetVersionAccessors vaccForNetVersionAccessors = new NetVersionAccessors(providers, config);
        private final OrgVersionAccessors vaccForOrgVersionAccessors = new OrgVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com</b>
         */
        public ComVersionAccessors getCom() {
            return vaccForComVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.net</b>
         */
        public NetVersionAccessors getNet() {
            return vaccForNetVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org</b>
         */
        public OrgVersionAccessors getOrg() {
            return vaccForOrgVersionAccessors;
        }

    }

    public static class ComVersionAccessors extends VersionFactory  {

        private final ComItextpdfVersionAccessors vaccForComItextpdfVersionAccessors = new ComItextpdfVersionAccessors(providers, config);
        private final ComMicrosoftVersionAccessors vaccForComMicrosoftVersionAccessors = new ComMicrosoftVersionAccessors(providers, config);
        private final ComToedterVersionAccessors vaccForComToedterVersionAccessors = new ComToedterVersionAccessors(providers, config);
        public ComVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.itextpdf</b>
         */
        public ComItextpdfVersionAccessors getItextpdf() {
            return vaccForComItextpdfVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.com.microsoft</b>
         */
        public ComMicrosoftVersionAccessors getMicrosoft() {
            return vaccForComMicrosoftVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.com.toedter</b>
         */
        public ComToedterVersionAccessors getToedter() {
            return vaccForComToedterVersionAccessors;
        }

    }

    public static class ComItextpdfVersionAccessors extends VersionFactory  {

        public ComItextpdfVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.itextpdf.itextpdf</b> with value <b>5.5.13.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getItextpdf() { return getVersion("com.itextpdf.itextpdf"); }

    }

    public static class ComMicrosoftVersionAccessors extends VersionFactory  {

        private final ComMicrosoftSqlserverVersionAccessors vaccForComMicrosoftSqlserverVersionAccessors = new ComMicrosoftSqlserverVersionAccessors(providers, config);
        public ComMicrosoftVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.microsoft.sqlserver</b>
         */
        public ComMicrosoftSqlserverVersionAccessors getSqlserver() {
            return vaccForComMicrosoftSqlserverVersionAccessors;
        }

    }

    public static class ComMicrosoftSqlserverVersionAccessors extends VersionFactory  {

        private final ComMicrosoftSqlserverMssqlVersionAccessors vaccForComMicrosoftSqlserverMssqlVersionAccessors = new ComMicrosoftSqlserverMssqlVersionAccessors(providers, config);
        public ComMicrosoftSqlserverVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.microsoft.sqlserver.mssql</b>
         */
        public ComMicrosoftSqlserverMssqlVersionAccessors getMssql() {
            return vaccForComMicrosoftSqlserverMssqlVersionAccessors;
        }

    }

    public static class ComMicrosoftSqlserverMssqlVersionAccessors extends VersionFactory  {

        public ComMicrosoftSqlserverMssqlVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.microsoft.sqlserver.mssql.jdbc</b> with value <b>12.4.2.jre11</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJdbc() { return getVersion("com.microsoft.sqlserver.mssql.jdbc"); }

    }

    public static class ComToedterVersionAccessors extends VersionFactory  {

        public ComToedterVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.toedter.jcalendar</b> with value <b>1.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJcalendar() { return getVersion("com.toedter.jcalendar"); }

    }

    public static class NetVersionAccessors extends VersionFactory  {

        private final NetSfVersionAccessors vaccForNetSfVersionAccessors = new NetSfVersionAccessors(providers, config);
        public NetVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.net.sf</b>
         */
        public NetSfVersionAccessors getSf() {
            return vaccForNetSfVersionAccessors;
        }

    }

    public static class NetSfVersionAccessors extends VersionFactory  {

        private final NetSfJasperreportsVersionAccessors vaccForNetSfJasperreportsVersionAccessors = new NetSfJasperreportsVersionAccessors(providers, config);
        public NetSfVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.net.sf.jasperreports</b>
         */
        public NetSfJasperreportsVersionAccessors getJasperreports() {
            return vaccForNetSfJasperreportsVersionAccessors;
        }

    }

    public static class NetSfJasperreportsVersionAccessors extends VersionFactory  {

        public NetSfJasperreportsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>net.sf.jasperreports.jasperreports</b> with value <b>6.17.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJasperreports() { return getVersion("net.sf.jasperreports.jasperreports"); }

    }

    public static class OrgVersionAccessors extends VersionFactory  {

        private final OrgApacheVersionAccessors vaccForOrgApacheVersionAccessors = new OrgApacheVersionAccessors(providers, config);
        private final OrgJfreeVersionAccessors vaccForOrgJfreeVersionAccessors = new OrgJfreeVersionAccessors(providers, config);
        private final OrgKordampVersionAccessors vaccForOrgKordampVersionAccessors = new OrgKordampVersionAccessors(providers, config);
        private final OrgMindrotVersionAccessors vaccForOrgMindrotVersionAccessors = new OrgMindrotVersionAccessors(providers, config);
        private final OrgSpringframeworkVersionAccessors vaccForOrgSpringframeworkVersionAccessors = new OrgSpringframeworkVersionAccessors(providers, config);
        public OrgVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache</b>
         */
        public OrgApacheVersionAccessors getApache() {
            return vaccForOrgApacheVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.jfree</b>
         */
        public OrgJfreeVersionAccessors getJfree() {
            return vaccForOrgJfreeVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.kordamp</b>
         */
        public OrgKordampVersionAccessors getKordamp() {
            return vaccForOrgKordampVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.mindrot</b>
         */
        public OrgMindrotVersionAccessors getMindrot() {
            return vaccForOrgMindrotVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.springframework</b>
         */
        public OrgSpringframeworkVersionAccessors getSpringframework() {
            return vaccForOrgSpringframeworkVersionAccessors;
        }

    }

    public static class OrgApacheVersionAccessors extends VersionFactory  {

        private final OrgApacheCommonsVersionAccessors vaccForOrgApacheCommonsVersionAccessors = new OrgApacheCommonsVersionAccessors(providers, config);
        private final OrgApacheLoggingVersionAccessors vaccForOrgApacheLoggingVersionAccessors = new OrgApacheLoggingVersionAccessors(providers, config);
        private final OrgApacheMavenVersionAccessors vaccForOrgApacheMavenVersionAccessors = new OrgApacheMavenVersionAccessors(providers, config);
        private final OrgApachePoiVersionAccessors vaccForOrgApachePoiVersionAccessors = new OrgApachePoiVersionAccessors(providers, config);
        public OrgApacheVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.commons</b>
         */
        public OrgApacheCommonsVersionAccessors getCommons() {
            return vaccForOrgApacheCommonsVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.apache.logging</b>
         */
        public OrgApacheLoggingVersionAccessors getLogging() {
            return vaccForOrgApacheLoggingVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.apache.maven</b>
         */
        public OrgApacheMavenVersionAccessors getMaven() {
            return vaccForOrgApacheMavenVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.apache.poi</b>
         */
        public OrgApachePoiVersionAccessors getPoi() {
            return vaccForOrgApachePoiVersionAccessors;
        }

    }

    public static class OrgApacheCommonsVersionAccessors extends VersionFactory  {

        private final OrgApacheCommonsCommonsVersionAccessors vaccForOrgApacheCommonsCommonsVersionAccessors = new OrgApacheCommonsCommonsVersionAccessors(providers, config);
        public OrgApacheCommonsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.commons.commons</b>
         */
        public OrgApacheCommonsCommonsVersionAccessors getCommons() {
            return vaccForOrgApacheCommonsCommonsVersionAccessors;
        }

    }

    public static class OrgApacheCommonsCommonsVersionAccessors extends VersionFactory  {

        public OrgApacheCommonsCommonsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.apache.commons.commons.lang3</b> with value <b>3.12.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLang3() { return getVersion("org.apache.commons.commons.lang3"); }

    }

    public static class OrgApacheLoggingVersionAccessors extends VersionFactory  {

        private final OrgApacheLoggingLog4jVersionAccessors vaccForOrgApacheLoggingLog4jVersionAccessors = new OrgApacheLoggingLog4jVersionAccessors(providers, config);
        public OrgApacheLoggingVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.logging.log4j</b>
         */
        public OrgApacheLoggingLog4jVersionAccessors getLog4j() {
            return vaccForOrgApacheLoggingLog4jVersionAccessors;
        }

    }

    public static class OrgApacheLoggingLog4jVersionAccessors extends VersionFactory  {

        private final OrgApacheLoggingLog4jLog4jVersionAccessors vaccForOrgApacheLoggingLog4jLog4jVersionAccessors = new OrgApacheLoggingLog4jLog4jVersionAccessors(providers, config);
        public OrgApacheLoggingLog4jVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.logging.log4j.log4j</b>
         */
        public OrgApacheLoggingLog4jLog4jVersionAccessors getLog4j() {
            return vaccForOrgApacheLoggingLog4jLog4jVersionAccessors;
        }

    }

    public static class OrgApacheLoggingLog4jLog4jVersionAccessors extends VersionFactory  {

        public OrgApacheLoggingLog4jLog4jVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.apache.logging.log4j.log4j.core</b> with value <b>2.21.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCore() { return getVersion("org.apache.logging.log4j.log4j.core"); }

    }

    public static class OrgApacheMavenVersionAccessors extends VersionFactory  {

        private final OrgApacheMavenPluginsVersionAccessors vaccForOrgApacheMavenPluginsVersionAccessors = new OrgApacheMavenPluginsVersionAccessors(providers, config);
        public OrgApacheMavenVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.maven.plugins</b>
         */
        public OrgApacheMavenPluginsVersionAccessors getPlugins() {
            return vaccForOrgApacheMavenPluginsVersionAccessors;
        }

    }

    public static class OrgApacheMavenPluginsVersionAccessors extends VersionFactory  {

        private final OrgApacheMavenPluginsMavenVersionAccessors vaccForOrgApacheMavenPluginsMavenVersionAccessors = new OrgApacheMavenPluginsMavenVersionAccessors(providers, config);
        public OrgApacheMavenPluginsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.maven.plugins.maven</b>
         */
        public OrgApacheMavenPluginsMavenVersionAccessors getMaven() {
            return vaccForOrgApacheMavenPluginsMavenVersionAccessors;
        }

    }

    public static class OrgApacheMavenPluginsMavenVersionAccessors extends VersionFactory  {

        private final OrgApacheMavenPluginsMavenJarVersionAccessors vaccForOrgApacheMavenPluginsMavenJarVersionAccessors = new OrgApacheMavenPluginsMavenJarVersionAccessors(providers, config);
        public OrgApacheMavenPluginsMavenVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.maven.plugins.maven.jar</b>
         */
        public OrgApacheMavenPluginsMavenJarVersionAccessors getJar() {
            return vaccForOrgApacheMavenPluginsMavenJarVersionAccessors;
        }

    }

    public static class OrgApacheMavenPluginsMavenJarVersionAccessors extends VersionFactory  {

        public OrgApacheMavenPluginsMavenJarVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.apache.maven.plugins.maven.jar.plugin</b> with value <b>3.3.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getPlugin() { return getVersion("org.apache.maven.plugins.maven.jar.plugin"); }

    }

    public static class OrgApachePoiVersionAccessors extends VersionFactory  {

        private final OrgApachePoiPoiVersionAccessors vaccForOrgApachePoiPoiVersionAccessors = new OrgApachePoiPoiVersionAccessors(providers, config);
        public OrgApachePoiVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.poi.poi</b>
         */
        public OrgApachePoiPoiVersionAccessors getPoi() {
            return vaccForOrgApachePoiPoiVersionAccessors;
        }

    }

    public static class OrgApachePoiPoiVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        public OrgApachePoiPoiVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.apache.poi.poi</b> with value <b>5.2.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("org.apache.poi.poi"); }

        /**
         * Version alias <b>org.apache.poi.poi.ooxml</b> with value <b>5.2.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getOoxml() { return getVersion("org.apache.poi.poi.ooxml"); }

    }

    public static class OrgJfreeVersionAccessors extends VersionFactory  {

        public OrgJfreeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.jfree.jfreechart</b> with value <b>1.5.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJfreechart() { return getVersion("org.jfree.jfreechart"); }

    }

    public static class OrgKordampVersionAccessors extends VersionFactory  {

        private final OrgKordampIkonliVersionAccessors vaccForOrgKordampIkonliVersionAccessors = new OrgKordampIkonliVersionAccessors(providers, config);
        public OrgKordampVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.kordamp.ikonli</b>
         */
        public OrgKordampIkonliVersionAccessors getIkonli() {
            return vaccForOrgKordampIkonliVersionAccessors;
        }

    }

    public static class OrgKordampIkonliVersionAccessors extends VersionFactory  {

        private final OrgKordampIkonliIkonliVersionAccessors vaccForOrgKordampIkonliIkonliVersionAccessors = new OrgKordampIkonliIkonliVersionAccessors(providers, config);
        public OrgKordampIkonliVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.kordamp.ikonli.ikonli</b>
         */
        public OrgKordampIkonliIkonliVersionAccessors getIkonli() {
            return vaccForOrgKordampIkonliIkonliVersionAccessors;
        }

    }

    public static class OrgKordampIkonliIkonliVersionAccessors extends VersionFactory  {

        private final OrgKordampIkonliIkonliMaterialdesignVersionAccessors vaccForOrgKordampIkonliIkonliMaterialdesignVersionAccessors = new OrgKordampIkonliIkonliMaterialdesignVersionAccessors(providers, config);
        public OrgKordampIkonliIkonliVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.kordamp.ikonli.ikonli.swing</b> with value <b>12.3.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSwing() { return getVersion("org.kordamp.ikonli.ikonli.swing"); }

        /**
         * Group of versions at <b>versions.org.kordamp.ikonli.ikonli.materialdesign</b>
         */
        public OrgKordampIkonliIkonliMaterialdesignVersionAccessors getMaterialdesign() {
            return vaccForOrgKordampIkonliIkonliMaterialdesignVersionAccessors;
        }

    }

    public static class OrgKordampIkonliIkonliMaterialdesignVersionAccessors extends VersionFactory  {

        public OrgKordampIkonliIkonliMaterialdesignVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.kordamp.ikonli.ikonli.materialdesign.pack</b> with value <b>12.3.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getPack() { return getVersion("org.kordamp.ikonli.ikonli.materialdesign.pack"); }

    }

    public static class OrgMindrotVersionAccessors extends VersionFactory  {

        public OrgMindrotVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.mindrot.jbcrypt</b> with value <b>0.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJbcrypt() { return getVersion("org.mindrot.jbcrypt"); }

    }

    public static class OrgSpringframeworkVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkSecurityVersionAccessors vaccForOrgSpringframeworkSecurityVersionAccessors = new OrgSpringframeworkSecurityVersionAccessors(providers, config);
        public OrgSpringframeworkVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springframework.security</b>
         */
        public OrgSpringframeworkSecurityVersionAccessors getSecurity() {
            return vaccForOrgSpringframeworkSecurityVersionAccessors;
        }

    }

    public static class OrgSpringframeworkSecurityVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkSecuritySpringVersionAccessors vaccForOrgSpringframeworkSecuritySpringVersionAccessors = new OrgSpringframeworkSecuritySpringVersionAccessors(providers, config);
        public OrgSpringframeworkSecurityVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springframework.security.spring</b>
         */
        public OrgSpringframeworkSecuritySpringVersionAccessors getSpring() {
            return vaccForOrgSpringframeworkSecuritySpringVersionAccessors;
        }

    }

    public static class OrgSpringframeworkSecuritySpringVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkSecuritySpringSecurityVersionAccessors vaccForOrgSpringframeworkSecuritySpringSecurityVersionAccessors = new OrgSpringframeworkSecuritySpringSecurityVersionAccessors(providers, config);
        public OrgSpringframeworkSecuritySpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springframework.security.spring.security</b>
         */
        public OrgSpringframeworkSecuritySpringSecurityVersionAccessors getSecurity() {
            return vaccForOrgSpringframeworkSecuritySpringSecurityVersionAccessors;
        }

    }

    public static class OrgSpringframeworkSecuritySpringSecurityVersionAccessors extends VersionFactory  {

        public OrgSpringframeworkSecuritySpringSecurityVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.springframework.security.spring.security.core</b> with value <b>5.2.1.RELEASE</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCore() { return getVersion("org.springframework.security.spring.security.core"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
