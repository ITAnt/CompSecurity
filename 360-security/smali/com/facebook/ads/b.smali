.class public Lcom/facebook/ads/b;
.super Landroid/widget/RelativeLayout;


# instance fields
.field private final a:Landroid/content/Context;

.field private final b:Lcom/facebook/ads/NativeAd;

.field private final c:Landroid/util/DisplayMetrics;

.field private d:Z

.field private e:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/facebook/ads/NativeAd;)V
    .locals 11

    const/16 v10, 0xf

    const/4 v9, -0x1

    const/4 v8, 0x0

    const/high16 v7, 0x40000000    # 2.0f

    invoke-direct {p0, p1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    iput-boolean v8, p0, Lcom/facebook/ads/b;->d:Z

    iput-object p1, p0, Lcom/facebook/ads/b;->a:Landroid/content/Context;

    iput-object p2, p0, Lcom/facebook/ads/b;->b:Lcom/facebook/ads/NativeAd;

    iget-object v0, p0, Lcom/facebook/ads/b;->a:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/ads/b;->c:Landroid/util/DisplayMetrics;

    iget-object v0, p0, Lcom/facebook/ads/b;->b:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd;->l()Lcom/facebook/ads/NativeAd$a;

    move-result-object v0

    new-instance v1, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd$a;->b()I

    move-result v2

    add-int/lit8 v2, v2, 0x4

    int-to-float v2, v2

    iget-object v3, p0, Lcom/facebook/ads/b;->c:Landroid/util/DisplayMetrics;

    iget v3, v3, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v2, v3

    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v2

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd$a;->c()I

    move-result v3

    add-int/lit8 v3, v3, 0x2

    int-to-float v3, v3

    iget-object v4, p0, Lcom/facebook/ads/b;->c:Landroid/util/DisplayMetrics;

    iget v4, v4, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v3, v4

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v3

    invoke-direct {v1, v2, v3}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    invoke-virtual {p0, v1}, Lcom/facebook/ads/b;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    new-instance v1, Lcom/facebook/ads/b$1;

    invoke-direct {v1, p0}, Lcom/facebook/ads/b$1;-><init>(Lcom/facebook/ads/b;)V

    invoke-virtual {p0, v1}, Lcom/facebook/ads/b;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    new-instance v1, Landroid/widget/ImageView;

    iget-object v2, p0, Lcom/facebook/ads/b;->a:Landroid/content/Context;

    invoke-direct {v1, v2}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    invoke-virtual {p0, v1}, Lcom/facebook/ads/b;->addView(Landroid/view/View;)V

    new-instance v2, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd$a;->b()I

    move-result v3

    int-to-float v3, v3

    iget-object v4, p0, Lcom/facebook/ads/b;->c:Landroid/util/DisplayMetrics;

    iget v4, v4, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v3, v4

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v3

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd$a;->c()I

    move-result v4

    int-to-float v4, v4

    iget-object v5, p0, Lcom/facebook/ads/b;->c:Landroid/util/DisplayMetrics;

    iget v5, v5, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v4, v5

    invoke-static {v4}, Ljava/lang/Math;->round(F)I

    move-result v4

    invoke-direct {v2, v3, v4}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    const/16 v3, 0x9

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    invoke-virtual {v2, v10, v9}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    const/high16 v3, 0x40800000    # 4.0f

    iget-object v4, p0, Lcom/facebook/ads/b;->c:Landroid/util/DisplayMetrics;

    iget v4, v4, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v3, v4

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v3

    iget-object v4, p0, Lcom/facebook/ads/b;->c:Landroid/util/DisplayMetrics;

    iget v4, v4, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v4, v7

    invoke-static {v4}, Ljava/lang/Math;->round(F)I

    move-result v4

    iget-object v5, p0, Lcom/facebook/ads/b;->c:Landroid/util/DisplayMetrics;

    iget v5, v5, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v5, v7

    invoke-static {v5}, Ljava/lang/Math;->round(F)I

    move-result v5

    iget-object v6, p0, Lcom/facebook/ads/b;->c:Landroid/util/DisplayMetrics;

    iget v6, v6, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v6, v7

    invoke-static {v6}, Ljava/lang/Math;->round(F)I

    move-result v6

    invoke-virtual {v2, v3, v4, v5, v6}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    invoke-static {v0, v1}, Lcom/facebook/ads/NativeAd;->a(Lcom/facebook/ads/NativeAd$a;Landroid/widget/ImageView;)V

    new-instance v0, Landroid/widget/TextView;

    iget-object v2, p0, Lcom/facebook/ads/b;->a:Landroid/content/Context;

    invoke-direct {v0, v2}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/facebook/ads/b;->e:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/facebook/ads/b;->e:Landroid/widget/TextView;

    invoke-virtual {p0, v0}, Lcom/facebook/ads/b;->addView(Landroid/view/View;)V

    new-instance v0, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v2, -0x2

    invoke-direct {v0, v8, v2}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    const/16 v2, 0xb

    invoke-virtual {v1}, Landroid/widget/ImageView;->getId()I

    move-result v1

    invoke-virtual {v0, v2, v1}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    invoke-virtual {v0, v10, v9}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    iget-object v1, p0, Lcom/facebook/ads/b;->e:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    iget-object v0, p0, Lcom/facebook/ads/b;->e:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->setSingleLine()V

    iget-object v0, p0, Lcom/facebook/ads/b;->e:Landroid/widget/TextView;

    const-string/jumbo v1, "AdChoices"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    iget-object v0, p0, Lcom/facebook/ads/b;->e:Landroid/widget/TextView;

    const/high16 v1, 0x41200000    # 10.0f

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextSize(F)V

    iget-object v0, p0, Lcom/facebook/ads/b;->e:Landroid/widget/TextView;

    const v1, -0x423e37

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    iput-boolean v8, p0, Lcom/facebook/ads/b;->d:Z

    return-void
.end method

.method private a()V
    .locals 5

    const/4 v4, 0x1

    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iget-object v1, p0, Lcom/facebook/ads/b;->e:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getTextSize()F

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    const-string/jumbo v1, "AdChoices"

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F

    move-result v0

    const/high16 v1, 0x40800000    # 4.0f

    iget-object v2, p0, Lcom/facebook/ads/b;->c:Landroid/util/DisplayMetrics;

    iget v2, v2, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v1, v2

    add-float/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v0

    invoke-virtual {p0}, Lcom/facebook/ads/b;->getWidth()I

    move-result v1

    add-int/2addr v0, v1

    iput-boolean v4, p0, Lcom/facebook/ads/b;->d:Z

    new-instance v2, Lcom/facebook/ads/b$2;

    invoke-direct {v2, p0, v1, v0}, Lcom/facebook/ads/b$2;-><init>(Lcom/facebook/ads/b;II)V

    new-instance v3, Lcom/facebook/ads/b$3;

    invoke-direct {v3, p0, v0, v1}, Lcom/facebook/ads/b$3;-><init>(Lcom/facebook/ads/b;II)V

    invoke-virtual {v2, v3}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    const-wide/16 v0, 0x12c

    invoke-virtual {v2, v0, v1}, Landroid/view/animation/Animation;->setDuration(J)V

    invoke-virtual {v2, v4}, Landroid/view/animation/Animation;->setFillAfter(Z)V

    invoke-virtual {p0, v2}, Lcom/facebook/ads/b;->startAnimation(Landroid/view/animation/Animation;)V

    return-void
.end method

.method static synthetic a(Lcom/facebook/ads/b;)Z
    .locals 1

    iget-boolean v0, p0, Lcom/facebook/ads/b;->d:Z

    return v0
.end method

.method static synthetic a(Lcom/facebook/ads/b;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcom/facebook/ads/b;->d:Z

    return p1
.end method

.method static synthetic b(Lcom/facebook/ads/b;)Lcom/facebook/ads/NativeAd;
    .locals 1

    iget-object v0, p0, Lcom/facebook/ads/b;->b:Lcom/facebook/ads/NativeAd;

    return-object v0
.end method

.method static synthetic c(Lcom/facebook/ads/b;)Landroid/content/Context;
    .locals 1

    iget-object v0, p0, Lcom/facebook/ads/b;->a:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic d(Lcom/facebook/ads/b;)V
    .locals 0

    invoke-direct {p0}, Lcom/facebook/ads/b;->a()V

    return-void
.end method

.method static synthetic e(Lcom/facebook/ads/b;)Landroid/widget/TextView;
    .locals 1

    iget-object v0, p0, Lcom/facebook/ads/b;->e:Landroid/widget/TextView;

    return-object v0
.end method
