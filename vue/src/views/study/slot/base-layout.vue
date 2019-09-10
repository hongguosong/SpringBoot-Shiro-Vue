<template>
    <div class="container">
        <header class="header">
            <slot name="header"></slot>
        </header>
        <main>
            <slot></slot>
        </main>
        <footer class="footer">
            <slot name="footer"></slot>
        </footer>
    </div>
</template>

<style scoped>
    .header {
        position: relative;
        margin: auto;
        width: 50%;
        text-align: center;
    }

    .footer {
        position: relative;
        margin: auto;
        width: 50%;
        text-align: center;
    }
</style>
