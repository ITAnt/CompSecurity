.class public Lezvcard/io/scribe/OrgDirectoryScribe;
.super Lezvcard/io/scribe/StringPropertyScribe;
.source "OrgDirectoryScribe.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lezvcard/io/scribe/StringPropertyScribe",
        "<",
        "Lezvcard/property/OrgDirectory;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 36
    const-class v0, Lezvcard/property/OrgDirectory;

    const-string v1, "ORG-DIRECTORY"

    invoke-direct {p0, v0, v1}, Lezvcard/io/scribe/StringPropertyScribe;-><init>(Ljava/lang/Class;Ljava/lang/String;)V

    .line 37
    return-void
.end method


# virtual methods
.method protected _parseValue(Ljava/lang/String;)Lezvcard/property/OrgDirectory;
    .locals 1
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 41
    new-instance v0, Lezvcard/property/OrgDirectory;

    invoke-direct {v0, p1}, Lezvcard/property/OrgDirectory;-><init>(Ljava/lang/String;)V

    return-object v0
.end method

.method protected bridge synthetic _parseValue(Ljava/lang/String;)Lezvcard/property/VCardProperty;
    .locals 1
    .param p1, "x0"    # Ljava/lang/String;

    .prologue
    .line 34
    invoke-virtual {p0, p1}, Lezvcard/io/scribe/OrgDirectoryScribe;->_parseValue(Ljava/lang/String;)Lezvcard/property/OrgDirectory;

    move-result-object v0

    return-object v0
.end method
