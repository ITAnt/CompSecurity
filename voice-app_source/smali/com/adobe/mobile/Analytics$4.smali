.class final Lcom/adobe/mobile/Analytics$4;
.super Ljava/lang/Object;
.source "Analytics.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/mobile/Analytics;->trackBeacon(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/adobe/mobile/Analytics$BEACON_PROXIMITY;Ljava/util/Map;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$cdata:Ljava/util/Map;

.field final synthetic val$major:Ljava/lang/String;

.field final synthetic val$minor:Ljava/lang/String;

.field final synthetic val$proximity:Lcom/adobe/mobile/Analytics$BEACON_PROXIMITY;

.field final synthetic val$uuid:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/adobe/mobile/Analytics$BEACON_PROXIMITY;Ljava/util/Map;)V
    .locals 0

    .prologue
    .line 100
    iput-object p1, p0, Lcom/adobe/mobile/Analytics$4;->val$uuid:Ljava/lang/String;

    iput-object p2, p0, Lcom/adobe/mobile/Analytics$4;->val$major:Ljava/lang/String;

    iput-object p3, p0, Lcom/adobe/mobile/Analytics$4;->val$minor:Ljava/lang/String;

    iput-object p4, p0, Lcom/adobe/mobile/Analytics$4;->val$proximity:Lcom/adobe/mobile/Analytics$BEACON_PROXIMITY;

    iput-object p5, p0, Lcom/adobe/mobile/Analytics$4;->val$cdata:Ljava/util/Map;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 102
    iget-object v0, p0, Lcom/adobe/mobile/Analytics$4;->val$uuid:Ljava/lang/String;

    iget-object v1, p0, Lcom/adobe/mobile/Analytics$4;->val$major:Ljava/lang/String;

    iget-object v2, p0, Lcom/adobe/mobile/Analytics$4;->val$minor:Ljava/lang/String;

    iget-object v3, p0, Lcom/adobe/mobile/Analytics$4;->val$proximity:Lcom/adobe/mobile/Analytics$BEACON_PROXIMITY;

    iget-object v4, p0, Lcom/adobe/mobile/Analytics$4;->val$cdata:Ljava/util/Map;

    invoke-static {v0, v1, v2, v3, v4}, Lcom/adobe/mobile/AnalyticsTrackBeacon;->trackBeacon(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/adobe/mobile/Analytics$BEACON_PROXIMITY;Ljava/util/Map;)V

    .line 103
    return-void
.end method
